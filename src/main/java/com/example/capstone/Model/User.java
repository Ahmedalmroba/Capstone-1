package com.example.capstone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "must not be null")
    private int id;
    @NotEmpty(message = "must not be empty")
    @Size(min = 5)
    private String username;
    @NotEmpty(message = "must not be empty")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.[a-zA-Z])(?=.[0-9]).{6,}$")
    private String password;
    @NotEmpty(message = "must not be empty")
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "Admin|Customer")
    private String role;
    @NotNull(message = "must not be null")
    @Positive
    private double balance;

}
