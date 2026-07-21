package com.example.pack.group;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
        @GeneratedValue
        private Integer id;

        @Column(
                name = "group_name"
        )
        private String name;
        
}
