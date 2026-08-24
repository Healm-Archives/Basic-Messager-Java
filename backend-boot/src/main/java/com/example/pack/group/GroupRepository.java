package com.example.pack.group;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupJpaEntity, UUID>{
        public List<GroupJpaEntity> findAllByMemberListUuid(UUID userUuid);

        public List<GroupJpaEntity> findAllByNameStartsWith(String name);

}
