package com.springproject.controller;

import com.springproject.dto.EmployeeRequest;
import com.springproject.dto.EmployeeResponse;
import com.springproject.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeResponse>
    create(
            @Valid
            @RequestBody EmployeeRequest request) {

        return ResponseEntity.ok(
                service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse>
    getById(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>>
    getAll() {

        return ResponseEntity.ok(
                service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse>
    update(
            @PathVariable Long id,
            @Valid
            @RequestBody EmployeeRequest request) {

        return ResponseEntity.ok(
                service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                "Employee deleted successfully");
    }
}