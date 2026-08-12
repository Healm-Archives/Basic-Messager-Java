package com.example.pack.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "m_user")
public class UserJpaEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID uuid;

        @Column(
                unique = true,
                nullable = false
        )
        private String name;
        
        // @Size(min = 6, message = "Password must be at least 6 characters")
        private String password;

}
