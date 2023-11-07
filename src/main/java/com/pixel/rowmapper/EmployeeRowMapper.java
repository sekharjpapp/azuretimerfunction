package com.pixel.rowmapper;

import com.pixel.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("employee_Id"));
        employee.setEmployeeName(rs.getString("employee_name"));
        employee.setEmail(rs.getString("email"));
        employee.setGender(rs.getString("gender"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;

    }
}
