package com.example.pack.message.adapter.outbound.persistence;

import com.example.pack.user.adapter.outbound.persistence.UserJpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
        private Integer id;
        
        @Column(
                nullable = false
        )
        private String content;
        
        @ManyToOne
        @JoinColumn(
                name = "user_id"
        )
        private UserJpaEntity user;
        
}
