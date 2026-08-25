package com.example.pack.group;

import java.util.UUID;

public record GroupEditDto(
        UUID groupUuid,
        String groupName,
        String description
) {}
