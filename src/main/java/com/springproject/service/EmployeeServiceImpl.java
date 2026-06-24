package com.springproject.service;

import com.springproject.dto.EmployeeRequest;
import com.springproject.dto.EmployeeResponse;
import com.springproject.entity.Employee;
import com.springproject.exception.DuplicateResourceException;
import com.springproject.exception.ResourceNotFoundException;
import com.springproject.mapper.EmployeeMapper;
import com.springproject.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl
        implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeResponse create(
            EmployeeRequest request) {

        if(repository.existsByEmail(
                request.getEmail())) {

            throw new DuplicateResourceException(
                    "Email already exists");
        }

        Employee employee =
                mapper.toEntity(request);

        return mapper.toResponse(
                repository.save(employee));
    }

    @Override
    public EmployeeResponse getById(Long id) {

        Employee employee =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found"));

        return mapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse update(
            Long id,
            EmployeeRequest request) {

        Employee employee =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found"));

        employee.setFirstName(
                request.getFirstName());

        employee.setLastName(
                request.getLastName());

        employee.setEmail(
                request.getEmail());

        employee.setPhone(
                request.getPhone());

        employee.setSalary(
                request.getSalary());

        employee.setJoinDate(
                request.getJoinDate());

        return mapper.toResponse(
                repository.save(employee));
    }

    @Override
    public void delete(Long id) {

        Employee employee =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found"));

        repository.delete(employee);
    }
}
