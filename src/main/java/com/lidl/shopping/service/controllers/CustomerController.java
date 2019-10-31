package com.lidl.shopping.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidl.shopping.logic.OrderService;
import com.lidl.shopping.models.Customer;
import com.lidl.shopping.models.Order;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderService orderService; 
    
    @GetMapping(path = "/{customerId}/orders")
    public List<Order> getAllOrdersForCustomer(@PathVariable Integer customerId) {
        return orderService.getOrdersForCustomer(customerId);
    }
    
    @GetMapping(path = "/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        return orderService.getCustomer(customerId);
    }

}
