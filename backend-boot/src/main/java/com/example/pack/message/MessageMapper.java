package com.example.pack.message;

import org.springframework.stereotype.Service;

import com.example.pack.message.dto.MessageChatDto;
import com.example.pack.message.dto.MessageDto;
import com.example.pack.user.UserJpaEntity;

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

        // public MessageChatDto toChatDto(MessageJpaEntity entity){
        //         return new MessageChatDto(
        //                 entity.getContent(),
        //                 "name here",
        //                 entity.getUserUuid(),
        //                 entity.getTimestamp()
        //         );
        // }
}
