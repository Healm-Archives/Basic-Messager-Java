package com.example.pack.message;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
        private final MessageRepository messageRepository;
        private final MessageMapper messageMapper;
        
        public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
                this.messageRepository = messageRepository;
                this.messageMapper = messageMapper;
        }

        public void addMessage(MessageDto dto){
                var message = messageMapper.dtoToMessage(dto);
                messageRepository.save(message);
        }

}
