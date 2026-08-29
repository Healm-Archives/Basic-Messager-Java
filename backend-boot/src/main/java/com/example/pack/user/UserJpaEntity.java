package com.example.pack.user;

import java.util.List;
import java.util.UUID;

import com.example.pack.group.GroupJpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

        private String password;

        // @JsonBackReference
        @ManyToMany(
                mappedBy = "memberList"
        )
        private List<GroupJpaEntity> groupList;
        
}
