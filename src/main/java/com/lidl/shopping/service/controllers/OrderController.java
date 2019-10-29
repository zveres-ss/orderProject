package com.lidl.shopping.service.controllers;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidl.shopping.models.Order;
import com.lidl.shopping.service.exceptions.OrderNotFoundException;

@RequestMapping("/orders")
@RestController
public class OrderController {
    
    private static Map<Integer, Order> orders = new HashMap<>();
    private static AtomicInteger id = new AtomicInteger();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders() {
        return new LinkedList<Order>(orders.values());
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Integer id) {
        Order order = orders.get(id);
        if (order == null) {
            throw new OrderNotFoundException("order with id:" + id + " not found");
        }
        return order;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order order) {
        order.setId(id.getAndIncrement());
        orders.put(order.getId(), order);
        return order;
    }
    
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order) {
        orders.put(order.getId(), order);
        return order;
    }
    
    @DeleteMapping(path="/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orders.remove(id);
    }
}
