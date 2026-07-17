package com.example.pack.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "message_user")
public class UserJpaEntity {
        @Id
        @GeneratedValue
        private Integer id;

        @Column(
                unique = true,
                nullable = false
        )
        private String name;

}
