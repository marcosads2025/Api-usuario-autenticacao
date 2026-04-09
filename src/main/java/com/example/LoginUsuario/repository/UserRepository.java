package com.example.LoginUsuario.repository;

import com.example.LoginUsuario.model.User; // ✅ IMPORT CORRETO
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}