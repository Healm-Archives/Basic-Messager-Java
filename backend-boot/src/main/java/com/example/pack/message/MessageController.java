package com.example.pack.message;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class MessageController {
        private final MessageService messageService;
        
        @PostMapping("/message")
        public void addMessage(
                @RequestBody MessageDto dto
        ) {
                messageService.addMessage(dto);
        }
        
        // @GetMapping("/messages")
        // public List<MessageDto> getMessages() {
        //     return messageService.getAllMessages();
        // }

        // @GetMapping("/messages/{user-id}")
        // public List<MessageDto> getAllMessageByUserId(@PathVariable("user-id") UUID id) {
        //     return messageService.getAllMessageByUserId(id);
        // }
        

}
