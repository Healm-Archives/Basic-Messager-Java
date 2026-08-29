package com.example.pack.group.dto;

import java.util.UUID;

public record GroupEditDto(
        UUID groupUuid,
        String groupName,
        String description
) {}
