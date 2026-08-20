package com.example.pack.group;

import java.util.UUID;

public record GroupInfoDto(
        UUID groupUuid,
        String name
        // String description
) {}
