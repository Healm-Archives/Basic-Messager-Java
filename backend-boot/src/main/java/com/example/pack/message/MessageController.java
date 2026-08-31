package com.example.pack.message;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pack.message.dto.MessageChatDto;
import com.example.pack.message.dto.MessageDto;
import com.example.pack.message.dto.MessageGroupDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class MessageController {
        private final MessageService messageService;
        
        @PostMapping("/message/send")
        public void addMessageInGroup(
                @RequestBody MessageDto dto
        ) {
                messageService.addMessageInGroup(dto);
        }
        
        @PostMapping("/messages/get")
        public List<MessageChatDto> getAllMessagesInAGroup(
                @RequestBody MessageGroupDto groupDto
        ) {
            return messageService.getAllMessagesInGroup(groupDto);
        }
        

}
