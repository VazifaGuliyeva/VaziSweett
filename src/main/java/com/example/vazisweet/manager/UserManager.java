package com.example.vazisweet.manager;

import com.example.vazisweet.dto.RegisterRequest;
import com.example.vazisweet.dto.UserDto;
import com.example.vazisweet.dto.UserDtoManager;
import com.example.vazisweet.dto.UserRequestResponse;
import com.example.vazisweet.mapper.UserMapper;
import com.example.vazisweet.repository.UserRepository;
import com.example.vazisweet.service.UserService;
import lombok.AllArgsConstructor;
import com.example.vazisweet.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.vazisweet.exception.UserNotFoundException;


@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper ;

    private final PasswordEncoder encoder;



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

    @Override
    public UserRequestResponse getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userMapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }
}
