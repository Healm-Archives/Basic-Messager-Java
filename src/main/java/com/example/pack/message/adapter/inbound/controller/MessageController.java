package com.example.pack.message.adapter.inbound.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pack.message.application.dto.MessageDto;
import com.example.pack.message.application.service.MessageService;


@RestController
public class MessageController {
        private final MessageService messageService;

        public MessageController(MessageService messageService) {
                this.messageService = messageService;
        }
        
        @PostMapping("/message")
        public void addMessage(@RequestBody MessageDto dto) {
                messageService.addMessage(dto);
        }
        
        @GetMapping("/messages")
        public List<MessageDto> getMessages() {
            return messageService.getAllMessages();
        }

        @GetMapping("/messages/{user-id}")
        public List<MessageDto> getAllMessageByUserId(@PathVariable("user-id") Integer id) {
            return messageService.getAllMessageByUserId(id);
        }
        

}
