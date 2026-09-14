package com.example.pack.message;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pack.message.dto.MessageChatDto;
import com.example.pack.message.dto.MessageDto;
import com.example.pack.message.dto.MessageGroupDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
        private final MessageRepository messageRepository;
        private final MessageMapper messageMapper;

        public void addMessageInGroup(MessageDto dto){
                MessageJpaEntity message = messageMapper.toEntity(dto);                
                messageRepository.save(message);
        }

        public List<MessageChatDto> getAllMessagesInGroup(MessageGroupDto groupDto) {
                return messageRepository.findAllByGroupUuid2(groupDto.groupUuid());
                // return messageRepository.findAllByGroupUuid(groupDto.groupUuid())
                        // .stream()
                        // .map(messageMapper::toChatDto)
                        // .toList()
                        // ;
        }

}
