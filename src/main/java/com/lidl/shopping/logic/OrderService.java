package com.lidl.shopping.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidl.shopping.models.Customer;
import com.lidl.shopping.models.Order;
import com.lidl.shopping.persistence.dao.CustomerRepository;
import com.lidl.shopping.persistence.dao.OrderRepository;
import com.lidl.shopping.persistence.dao.OrderSpringJDBCDao;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private OrderSpringJDBCDao orderDao;
    
    public Order createOrder(Order order) {
        
        //orderDao.createOrder(order);
        
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Lidl");
        customer.setLastName("the Great");
        order.setCustomer(customerRepository.save(customer));
        
        return saveOrder(order);
    }
    
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
    public Optional<Order> getOrder(Integer id) {
        
        // jdbc-based dao
        //orderDao.getOrder();
        
        return orderRepository.findById(id);
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public List<Order> getOrdersForCustomer(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
    
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }
}
