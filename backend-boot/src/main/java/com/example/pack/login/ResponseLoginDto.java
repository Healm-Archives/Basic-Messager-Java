package com.example.pack.login;

import java.util.List;
import java.util.UUID;

public record ResponseLoginDto(
        String token,
        UUID userUuid,
        List<String> message
) {

}
