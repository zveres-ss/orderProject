package com.lidl.shopping.persistence.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lidl.shopping.models.Order;

@Repository
public class OrderSpringJDBCDao {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Order getOrder() {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM `Order` WHERE idOrder = 1", 
                Order.class);
    }
}
