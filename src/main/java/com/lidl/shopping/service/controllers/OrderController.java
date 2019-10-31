package com.lidl.shopping.service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidl.shopping.logic.OrderService;
import com.lidl.shopping.models.Order;
import com.lidl.shopping.service.exceptions.OrderNotFoundException;

@RequestMapping("/orders")
@RestController
public class OrderController {
    
    @Autowired 
    private OrderService orderService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Integer id) {
        
        Optional<Order> order = orderService.getOrder(id);
        
        if (order.isEmpty()) {
            throw new OrderNotFoundException("order with id:" + id + " not found");
        }
        return order.get();
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order order) {
       
        Order storedOrder = orderService.createOrder(order);
        
        return storedOrder;
    }
    
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order) {
        Order storedOrder = orderService.createOrder(order);
        
        return storedOrder;
    }
    
    @DeleteMapping(path="/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
