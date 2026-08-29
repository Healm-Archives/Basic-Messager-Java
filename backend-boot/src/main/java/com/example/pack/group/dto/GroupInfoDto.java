package com.example.pack.group.dto;

import java.util.UUID;

public record GroupInfoDto(
        UUID groupUuid,
        String groupName
        // String description
) {}
