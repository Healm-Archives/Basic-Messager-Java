package com.example.pack.message;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
        private final MessageRepository messageRepository;
        private final MessageMapper messageMapper;

        public void addMessage(MessageDto dto){
                var message = messageMapper.dtoToMessage(dto);
                messageRepository.save(message);
        }

        public List<MessageDto> getAllMessages(){
                return messageRepository
                        .findAll()
                        .stream()
                        .map(messageMapper::toDto)
                        .toList();
        }

        public List<MessageDto> getAllMessageByUserId(Integer id){
                return messageRepository
                        .findAllByUserId(id)
                        .stream()
                        .map(messageMapper::toDto)
                        .toList();
        }

}
