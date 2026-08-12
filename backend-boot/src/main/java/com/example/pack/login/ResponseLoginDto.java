package com.example.pack.login;

import java.util.List;

public record ResponseLoginDto(
        String token,
        List<String> message
) {

}
