package com.example.pack.message;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "message")
public class MessageJpaEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(
                name = "message_uuid"
        )
        private UUID uuid;
        
        @Column(
                name = "user_uuid"
                , nullable = false
        )
        private UUID userUuid;
        
        @Column(
                name = "group_uuid"
                , nullable = false
        )
        private UUID groupUuid;

        private ZonedDateTime timestamp;

        @Column(
                nullable = false
        )
        private String content;
        
        
        
}
