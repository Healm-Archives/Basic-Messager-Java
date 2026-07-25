package com.example.pack.message;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageJpaEntity, UUID> 
{
        public List<MessageJpaEntity> findAll();

        public List<MessageJpaEntity> findAllByUserUuid(UUID uuid);

}
