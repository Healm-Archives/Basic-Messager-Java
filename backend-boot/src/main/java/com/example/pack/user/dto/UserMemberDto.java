package com.example.pack.user.dto;

import java.util.UUID;

public record UserMemberDto(
        UUID userUuid,
        String name
) {}
