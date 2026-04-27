package com.example.pack.user.adapter.outbound.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpaEntity, Integer>
{
        public List<UserJpaEntity> findAll();

        // both works
        // public List<User> findAllByNameStartsWith(String name);
        public List<UserJpaEntity> findByNameStartsWith(String name);

}
