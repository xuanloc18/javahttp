package com.example.practice.exercise.repository;

import com.example.practice.exercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
