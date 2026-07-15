package com.example.pack.message;

import org.springframework.stereotype.Service;

import com.example.pack.user.UserJpaEntity;

@Service
public class MessageMapper {
        public MessageJpaEntity dtoToMessage(MessageDto msgDto){
                UserJpaEntity user = new UserJpaEntity();
                user.setId(msgDto.userId());
                
                var message = new MessageJpaEntity();
                message.setContent(msgDto.content());
                message.setUser(user);

                return message;
        }
        public MessageDto toDto(MessageJpaEntity message){
                return new MessageDto(
                        message.getContent(), 
                        message.getUser().getId()
                );
        }
}
