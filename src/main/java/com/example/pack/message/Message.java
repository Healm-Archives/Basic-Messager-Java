package com.example.pack.message;

import com.example.pack.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
        @GeneratedValue
        public Integer id;
        
        @Column(
                nullable = false
        )
        public String content;
        
        @OneToOne(
                mappedBy = "id"
        )
        public User user;

}
