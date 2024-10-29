
package com.example.Test.Service.Impl;

import com.example.Test.Dto.UserDto;
import com.example.Test.Entity.User;
import com.example.Test.Repository.UserRepository;
import com.example.Test.Service.LoginService;
import com.example.Test.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String login(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

                return jwtUtil.generateToken(userDetails);
            }
        }
        return null;
    }
}

