package com.example.pack.message;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MessageController {
        private final MessageRepository messageRepository;

        public MessageController(MessageRepository messageRepository) {
                this.messageRepository = messageRepository;
        }

        // @GetMapping("/message")
        // public List<Message> getMessages() {
        //     return messageRepository.getMessages();
        // }
        
        // @PostMapping("/path")
        // public void postMethodName(@RequestBody Message message) {
                
        // }
        

}
