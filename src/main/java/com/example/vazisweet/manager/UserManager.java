package com.example.vazisweet.manager;

import com.example.vazisweet.dto.*;
import com.example.vazisweet.mapper.UserMapper;
import com.example.vazisweet.repository.UserRepository;
import com.example.vazisweet.security.JwtService;
import com.example.vazisweet.service.UserService;
import lombok.AllArgsConstructor;
import com.example.vazisweet.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.vazisweet.exception.UserNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper ;

    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;




    @Override
    public User  saveUser(UserRequestResponse userDto) {
        return userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }



    @Override
    public User getUserByEmail(String email) {
        return userRepository.
                findUserByEmail(email).
                orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }

    @Override
    public void register(RegisterRequest request) {
        User user = userMapper.toUserFromRegisterRequest(request);
        user.setPassword(encoder.encode(request.password()));
        userRepository.save(user);

    }

    public List<UserRequestResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UserDetails user = userMapper.toMyUserDetails(getUserByEmail(request.email()));

        return jwtService.generateToken(user);
    }


    @Override
    public UserRequestResponse getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userMapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }
}
