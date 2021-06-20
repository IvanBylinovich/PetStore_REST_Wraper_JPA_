package com.example.demo.repository;

import com.example.demo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, Long> {
     boolean existsByKey(UUID key);
}
