package com.example.pack.global;

import java.util.List;

public record GlobalResponseDto(
        List<String> messages
) {
        public GlobalResponseDto(String message){
                this(List.of(message));
        }
}
