package com.springproject.mapper;

import com.springproject.dto.EmployeeRequest;
import com.springproject.dto.EmployeeResponse;
import com.springproject.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setJoinDate(request.getJoinDate());

        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .employeeCode(employee.getEmployeeCode())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .salary(employee.getSalary())
                .joinDate(employee.getJoinDate())
                .build();
    }
}
