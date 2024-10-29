package com.example.Test.Controller;

import com.example.Test.Dto.UserDto;
import com.example.Test.Entity.User;
import com.example.Test.Repository.UserRepository;
import com.example.Test.Service.LoginService;
import com.example.Test.Service.RegisterService;
import com.example.Test.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        String token = loginService.login(userDto);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

@GetMapping("/user")
public ResponseEntity<?> getUserDetails(Principal principal) {
    String username = principal.getName();

    Optional<User> user = userRepository.findByEmail(username);

    if (user.isPresent()) {
        return ResponseEntity.ok(user.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
    @GetMapping("/admin")

    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("Welcome to Admin Profile");

}
    @GetMapping("/users")

    public ResponseEntity<String> userAccess() {
        return ResponseEntity.ok("Welcome to User Profile");

    }
}
