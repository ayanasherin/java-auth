package com.example.Test.Service.Impl;

import com.example.Test.Dto.UserDto;
import com.example.Test.Entity.User;
import com.example.Test.Repository.UserRepository;
import com.example.Test.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registration(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setRole(userDto.getRole());

        return userrepository.save(user);

    }

}
