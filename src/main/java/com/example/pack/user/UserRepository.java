package com.example.pack.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
        public List<User> findAll();

        // both works
        // public List<User> findAllByNameStartsWith(String name);
        public List<User> findByNameStartsWith(String name);

}
