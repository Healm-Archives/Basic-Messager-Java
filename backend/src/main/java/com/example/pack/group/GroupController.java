package com.example.pack.group;

import org.springframework.web.bind.annotation.RestController;

import com.example.pack.message.MessageJpaEntity;
import com.example.pack.message.MessageRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GroupController {

        private final MessageRepository messageRepository;

        public GroupController(MessageRepository messageRepository) {
                this.messageRepository = messageRepository;
        }



        @GetMapping("/group")
        public List<MessageJpaEntity> getGroupChat(
                
        ) {
                return messageRepository.findAll();
        }
        
}
