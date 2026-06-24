package com.springproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeResponse {

    private Long id;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private BigDecimal salary;

    private LocalDate joinDate;
}