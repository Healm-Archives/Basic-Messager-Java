package com.example.pack.group;

import java.util.List;
import java.util.UUID;

import com.example.pack.user.UserJpaEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "m_group")
public class GroupJpaEntity {
        
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID uuid;

        @Column(
                name = "group_name"
        )
        private String name;

        private String description;

        // @JsonManagedReference
        @ManyToMany
        @JoinTable(
                name = "group_member",
                joinColumns = {
                        @JoinColumn(name = "group_uuid")
                },
                inverseJoinColumns = {
                        @JoinColumn(name = "user_uuid")
                }
        )
        private List<UserJpaEntity> memberList;
        
}
