package com.example.Test.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
    private int id;
    @NotBlank(message = "Email is required")
    //@Email(message = "Email should be valid")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="E-mail is invalid")

    private String email;

//    @NotBlank(message = "Password Cannot be blank")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d).+$",
//            message = "Password must contain at least one uppercase letter, one special character, and one digit")
//@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
//         message = "Password must contain at least one letter, one number, and one special character.")
//
//        @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}",message = "Password must be at least 8 characters long, contain at least one letter, one number and one special character")
//    @Size(min = 8, message = "Password must be at least 8 characters long")

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}",
            message = "Password must be 8-20 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
