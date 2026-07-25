package com.example.pack.group;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupJpaEntity, UUID>{

}
