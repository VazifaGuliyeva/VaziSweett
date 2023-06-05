package com.example.vazisweet.mapper;


import com.example.vazisweet.dto.RegisterRequest;
import com.example.vazisweet.dto.UserDto;
import com.example.vazisweet.dto.UserRequestResponse;
import com.example.vazisweet.entity.User;
import com.example.vazisweet.security.MyUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequestResponse toUserDto(User user);

    User toEntity(UserRequestResponse userRequestResponse);

    MyUserDetails toMyUserDetails(User user);

    User toUserFromRegisterRequest(RegisterRequest request);
}
