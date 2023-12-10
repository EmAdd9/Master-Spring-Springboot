package com.emadd9.springboot.demoapplication.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
