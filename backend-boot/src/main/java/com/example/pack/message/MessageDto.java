package com.example.pack.message;

import java.util.UUID;

public record MessageDto (
        String content,
        UUID userUuid
){}
