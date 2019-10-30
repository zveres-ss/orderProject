package com.lidl.shopping.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidl.shopping.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
