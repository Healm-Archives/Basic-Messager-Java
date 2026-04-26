package com.example.pack.message;

import com.example.pack.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
        @Id
        @GeneratedValue
        private Integer id;
        
        @Column(
                nullable = false
        )
        private String content;
        
        @OneToOne(

        )
        @JoinColumn(
                name = "student_id"
        )
        private User user;
        
}
