package com.example.pack.message;

import java.time.ZonedDateTime;
import java.util.UUID;

public record MessageDto(
        String content,
        UUID userUuid,
        UUID groupUuid,
        ZonedDateTime timestamp
) {}
