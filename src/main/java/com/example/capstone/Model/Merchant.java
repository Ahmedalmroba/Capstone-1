package com.example.capstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "must not be null ")
    private int id;
    @NotEmpty(message = "must not be empty")
    @Size(min = 3)
    private String name;
}
