package com.example.vazisweet.security;

import com.example.vazisweet.mapper.UserMapper;
import com.example.vazisweet.repository.UserRepository;
import com.example.vazisweet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toMyUserDetails(userRepository.findUserByEmail(username).get());
    }
}
