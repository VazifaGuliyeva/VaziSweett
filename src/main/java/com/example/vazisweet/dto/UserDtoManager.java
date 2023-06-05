package com.example.vazisweet.dto;


import com.example.vazisweet.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoManager implements Function<User,UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getEmail(),user.getPassword());
    }


}
