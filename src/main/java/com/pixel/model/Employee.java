package com.pixel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer employeeId;
    private String employeeName;
    private String email;
    private String gender;
    private Double salary;

}
