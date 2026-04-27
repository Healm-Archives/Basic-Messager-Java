package com.example.pack.message.adapter.outbound.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageJpaEntity, Integer> 
{
        public List<MessageJpaEntity> findAll();

        public List<MessageJpaEntity> findAllByUserId(Integer id);

}
