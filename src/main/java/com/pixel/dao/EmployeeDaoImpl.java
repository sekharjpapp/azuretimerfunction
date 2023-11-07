package com.pixel.dao;

import com.pixel.model.Employee;
import com.pixel.rowmapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDAO{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_GET_ALL = "select * from employee";
    @Override
    public List<Employee> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL, new EmployeeRowMapper());
    }
}
