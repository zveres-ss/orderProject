package com.lidl.shopping.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidl.shopping.models.Order;
import com.lidl.shopping.persistence.dao.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
    
    public Optional<Order> getOrder(Integer id) {
        return orderRepository.findById(id);
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
