package com.springproject.controller;

import com.springproject.dto.UserRequest;
import com.springproject.dto.UserResponse;
import com.springproject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse>
    create(
            @Valid
            @RequestBody UserRequest request) {

        return ResponseEntity.ok(
                userService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>>
    getAll() {

        return ResponseEntity.ok(
                userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>
    getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse>
    update(
            @PathVariable Long id,
            @Valid
            @RequestBody UserRequest request) {

        return ResponseEntity.ok(
                userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    delete(
            @PathVariable Long id) {

        userService.delete(id);

        return ResponseEntity.ok(
                "User deleted successfully");
    }
}