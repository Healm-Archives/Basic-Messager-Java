package com.example.pack.message;

import org.springframework.stereotype.Service;

@Service
public class MessageMapper {
        public MessageJpaEntity dtoToMessage(MessageDto msgDto){
                return MessageJpaEntity.builder()
                        .userUuid(msgDto.userUuid())
                        .groupUuid(msgDto.groupUuid())
                        .timestamp(msgDto.timestamp())
                        .content(msgDto.content())
                        .build();

        }

        // public MessageDto toDto(MessageJpaEntity message){
        //         return new MessageDto(
        //                 message.getContent(), 
        //                 message.getUser().getUuid()
        //         );
        // }
}
