package com.example.capstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "must not be null ")
    private int id;

    @NotEmpty(message = "must not be empty")
    private String productid;
    @NotEmpty(message = "must not be empty")
    private String merchantid;
    @NotNull(message = "must not be null ")
    @Size(min = 10)
    private int stock;
}
