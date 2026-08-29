package com.example.pack.group.dto;

import jakarta.validation.constraints.NotBlank;

public record GroupCreateDto(
        @NotBlank(message = "Group name should be not blank")
        String name
){}
