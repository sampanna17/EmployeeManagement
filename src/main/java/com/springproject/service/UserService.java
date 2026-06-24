package com.springproject.service;

import com.springproject.dto.UserRequest;
import com.springproject.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);

    UserResponse getById(Long id);

    List<UserResponse> getAll();

    UserResponse update(Long id,
                        UserRequest request);

    void delete(Long id);
}