package com.example.pack.message.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pack.message.adapter.outbound.persistence.MessageRepository;
import com.example.pack.message.application.dto.MessageDto;
import com.example.pack.message.mapper.MessageMapper;

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
