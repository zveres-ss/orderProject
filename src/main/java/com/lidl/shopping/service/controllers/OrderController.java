package com.lidl.shopping.service.controllers;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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

import com.lidl.shopping.models.Customer;
import com.lidl.shopping.models.Order;
import com.lidl.shopping.persistence.dao.CustomerRepository;
import com.lidl.shopping.persistence.dao.OrderRepository;
import com.lidl.shopping.persistence.dao.OrderSpringJDBCDao;
import com.lidl.shopping.service.exceptions.OrderNotFoundException;

@RequestMapping("/orders")
@RestController
public class OrderController {
    
    @Autowired
    private OrderSpringJDBCDao orderDao;
    
    @Autowired 
    private OrderRepository orderRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Integer id) {
        
        // jdbc-based dao
        //orderDao.getOrder();
        
        Optional<Order> order = orderRepository.findById(id);
        
        //small trash to remove
        orderRepository.findByTotalAmountGreaterThan(10.0);
        
        if (order.isEmpty()) {
            throw new OrderNotFoundException("order with id:" + id + " not found");
        }
        return order.get();
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order order) {
       
        //orderDao.createOrder(order);
        
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Lidl");
        customer.setLastName("the Great");
        order.setCustomer(customerRepository.save(customer));
        
        Order storedOrder = orderRepository.save(order);
        
        return storedOrder;
    }
    
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order) {
        Order storedOrder = orderRepository.save(order);
        
        return storedOrder;
    }
    
    @DeleteMapping(path="/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderRepository.deleteById(id);
    }
}
