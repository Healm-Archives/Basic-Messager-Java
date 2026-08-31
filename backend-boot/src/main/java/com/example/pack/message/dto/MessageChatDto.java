package com.example.pack.message.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public record MessageChatDto(
        String content,
        UUID userUuid,
        ZonedDateTime timestamp
) {}
