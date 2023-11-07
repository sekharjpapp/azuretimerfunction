package com.pixel.dao;

import com.pixel.model.Employee;
import com.pixel.rowmapper.EmployeeRowMapper;
import com.pixel.util.EmployeeQueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDAO{

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate template;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllPersons() {
        return jdbcTemplate.query(EmployeeQueryConstants.SQL_GET_ALL, new EmployeeRowMapper());
    }
    public void getListOfEmp() {
        String sql = "SELECT * FROM Employee WHERE employee_name=:name";

        SqlParameterSource param = new MapSqlParameterSource("name", "Bob");
        Employee result = template.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Employee.class));

        System.out.println(result);
    }
}
