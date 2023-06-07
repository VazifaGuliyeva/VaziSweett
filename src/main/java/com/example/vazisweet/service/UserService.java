package com.example.vazisweet.service;

import com.example.vazisweet.dto.RegisterRequest;
import com.example.vazisweet.dto.UserDto;
import com.example.vazisweet.dto.UserPageResponse;
import com.example.vazisweet.dto.UserRequestResponse;
import com.example.vazisweet.entity.User;

import java.util.List;

public interface UserService {

    UserRequestResponse getById(int id);


    User saveUser(UserRequestResponse user);

    void deleteUser(int id);

    User getUserByEmail(String email);

    void register(RegisterRequest request);

    List<UserRequestResponse> getAll();

    String login(RegisterRequest request);
}
