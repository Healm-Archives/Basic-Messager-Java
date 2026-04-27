package com.example.pack.message.mapper;

import org.springframework.stereotype.Service;

import com.example.pack.message.adapter.outbound.persistence.MessageJpaEntity;
import com.example.pack.message.application.dto.MessageDto;
import com.example.pack.user.adapter.outbound.persistence.UserJpaEntity;

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
