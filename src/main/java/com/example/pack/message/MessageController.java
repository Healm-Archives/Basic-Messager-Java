package com.example.pack.message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {
        private final MessageService messageService;

        public MessageController(MessageService messageService) {
                this.messageService = messageService;
        }

        // @GetMapping("/message")
        // public List<Message> getMessages() {
        //     return messageRepository.getMessages();
        // }

        @PostMapping("/message")
        public void addMessage(@RequestBody MessageDto dto) {
                messageService.addMessage(dto);
        }
        

}
