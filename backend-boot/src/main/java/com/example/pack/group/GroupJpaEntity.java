package com.example.pack.group;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@Table(name = "m_group")
public class GroupJpaEntity {
        
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID uuid;

        @Column(
                name = "group_name"
        )
        private String name;
        
}
