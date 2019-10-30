package com.lidl.shopping.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidl.shopping.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findByTotalAmountGreaterThan(Double totalAmount);
}
