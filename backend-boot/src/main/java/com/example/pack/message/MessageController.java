package com.example.pack.message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
