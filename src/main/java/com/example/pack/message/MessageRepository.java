package com.example.pack.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> 
{
        // public List<Message> getMessages();
}
