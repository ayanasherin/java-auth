package com.example.Test.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "User")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(nullable = false)
    private int id;

    @Column(unique = true, length = 45,nullable = false)
//    @NotEmpty(message="Email is required")
//    @Email(message = "Email should be valid")
//    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message ="E-mail is invalid")
    private String email;


    @Column(nullable = false)
    @NotEmpty(message = "Password is required")

//    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}",message = "Password must be at least 8 characters long, contain at least one letter, one number and one special character")
//    @Size(min = 8, message = "Password must be at least 8 characters long")
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
//            message = "Password must contain at least one letter, one number, and one special character.")
//    @NotBlank(message = "Password Cannot be blank")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d).+$",
//            message = "Password must contain at least one uppercase letter, one special character, and one digit")
    //private String password;
    private String password;



//    @Column(nullable = false)
//    private enum role{
//        Admin,

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
//        User;
//    }
//@Enumerated(EnumType.STRING)
//@Column(nullable = false)
//private Role roles;
//
//    public Role getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Role roles) {
//        this.roles = roles;
//    }
//@ManyToMany(fetch = FetchType.EAGER)
//private Collection<Role> roles = new ArrayList<>();
//
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }

    //
//
//    public enum Role {
//        ADMIN,
//        USER;
//    }
//@Column(nullable = false)
//@NotEmpty(message = "Role is required")
private String role;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
