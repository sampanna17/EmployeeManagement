package com.springproject.service;

import com.springproject.dto.EmployeeRequest;
import com.springproject.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    EmployeeResponse getById(Long id);

    List<EmployeeResponse> getAll();

    EmployeeResponse update(Long id,
                            EmployeeRequest request);

    void delete(Long id);
}
