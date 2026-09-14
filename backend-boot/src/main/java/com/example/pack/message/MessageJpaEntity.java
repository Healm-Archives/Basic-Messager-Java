package com.example.pack.message;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.example.pack.user.UserJpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
        @GeneratedValue
        @Column(
                name = "message_id"
        )
        private Integer id;
        
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
