package com.example.Test.Controller;

import com.example.Test.Dto.UserDto;
import com.example.Test.Entity.User;
import com.example.Test.Service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<User> registration(@Valid @RequestBody UserDto userDto) {
        User registeredUser = registerService.registration(userDto);
        return ResponseEntity.ok(registeredUser);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}


