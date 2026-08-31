package com.example.pack.message;

import org.springframework.stereotype.Service;

import com.example.pack.message.dto.MessageChatDto;
import com.example.pack.message.dto.MessageDto;

@Service
public class MessageMapper {
        public MessageJpaEntity toEntity(MessageDto msgDto){
                return MessageJpaEntity.builder()
                        .userUuid(msgDto.userUuid())
                        .groupUuid(msgDto.groupUuid())
                        .timestamp(msgDto.timestamp())
                        .content(msgDto.content())
                        .build();

        }

        public MessageChatDto toChatDto(MessageJpaEntity entity){
                return new MessageChatDto(
                        entity.getContent(),
                        entity.getUserUuid(),
                        entity.getTimestamp()
                );
        }
}
