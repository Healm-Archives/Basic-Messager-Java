package com.example.pack.group;

import jakarta.validation.constraints.NotBlank;

public record GroupDto(
        @NotBlank(message = "Group name should be not blank")
        String name
){}
