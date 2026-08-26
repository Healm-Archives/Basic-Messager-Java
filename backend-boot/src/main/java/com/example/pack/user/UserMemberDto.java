package com.example.pack.user;

import java.util.UUID;

public record UserMemberDto(
        UUID userUuid,
        String name
) {}
