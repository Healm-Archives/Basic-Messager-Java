package com.example.pack.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpaEntity, Integer>
{
        public List<UserJpaEntity> findAll();

        // both works
        // public List<UserJpaEntitys> findAllByNameStartsWith(String name);
        public List<UserJpaEntity> findByNameStartsWith(String name);

}
