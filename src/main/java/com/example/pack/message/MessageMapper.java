package com.example.pack.message;

import org.springframework.stereotype.Service;

import com.example.pack.user.User;

@Service
public class MessageMapper {
        public Message dtoToMessage(MessageDto msgDto){
                User user = new User();
                user.setId(msgDto.userId());
                
                var message = new Message();
                message.setContent(msgDto.content());
                message.setUser(user);

                return message;
        }
}
