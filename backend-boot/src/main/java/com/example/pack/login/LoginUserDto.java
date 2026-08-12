package com.example.pack.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUserDto(
        @NotBlank(message = "Please fill a name")
        String name,

        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
){}
