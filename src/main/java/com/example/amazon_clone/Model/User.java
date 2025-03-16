package com.example.amazon_clone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "the id can not be empty")
    private String id;
    @NotEmpty(message = "the username can not be empty")
    @Size(min = 5,message = "have to be more than 5 length long")
    private String username;
    @NotEmpty(message = "the password can not be empty")
    @Size(min = 6, message = "have to be more than 6 length long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$", message = "Password must contain both letters and digits")
    private String password;
    @Email(message = "Write a correct mail like this : (aaa@gmail.com)")
    private String email;
    @NotEmpty(message = "the role can not be empty")
    @Pattern(regexp = "Admin|Customer" , message = "You should choose (Admin or Customer)")
    private String role;
    @NotNull(message = "the balance can not be null")
    @Positive(message = "just positive numbers<")
    private int balance;
}
