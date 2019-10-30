package com.lidl.shopping.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidl.shopping.models.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
