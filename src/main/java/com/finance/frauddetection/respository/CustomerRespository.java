package com.finance.frauddetection.respository;

import com.finance.frauddetection.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRespository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Customer> rowMapper=(ResultSet rs, int rowNum) -> new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("account_number"),
            rs.getString("registered_country")
    );

    public CustomerRespository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Customer> getCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer",rowMapper);
    }
    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id=?",rowMapper,id);
    }
}