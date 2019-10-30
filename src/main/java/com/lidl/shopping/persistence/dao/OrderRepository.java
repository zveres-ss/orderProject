package com.lidl.shopping.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.lidl.shopping.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
