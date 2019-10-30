package com.lidl.shopping.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        return jdbcTemplate.queryForObject("SELECT * FROM `Order` WHERE idOrder = 1", new OrderMapper()
                );
    }

    public Order createOrder(Order order) {
        jdbcTemplate.update("INSERT INTO `Order` VALUES (?, ?, ?, ?, ?)", order.getId(), null, null, 100, null);
        return order;
    }

    class OrderMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int rowNumbewr) throws SQLException {
            Order order = new Order();
            order.setId(rs.getInt("idOrder"));
            return order;
        }

    }
}
