package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByIdEmail(String email);
}
