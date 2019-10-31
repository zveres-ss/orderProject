package com.lidl.shopping.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.EntityModel;

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
        List<Order> customerOrders = orderService.getOrdersForCustomer(customerId);
        
        return customerOrders;
    }
    
    @GetMapping(path = "/{customerId}")
    public EntityModel<Customer> getCustomer(@PathVariable Integer customerId) {
        Link link = linkTo(methodOn(CustomerController.class).getCustomer(customerId)).withSelfRel(); 
        return new EntityModel<Customer>(orderService.getCustomer(customerId), link);
    }

}
