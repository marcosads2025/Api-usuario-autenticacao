package com.example.LoginUsuario.controller;

import com.example.LoginUsuario.dto.UserRequestDTO;
import com.example.LoginUsuario.model.User;
import com.example.LoginUsuario.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody @Valid UserRequestDTO dto) {

        User user = service.salvar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

        @GetMapping
        public ResponseEntity<List<User>> listarTodos() {
            // Aqui o repository busca todos os registros no banco de dados
            ErrorPageSupport userRepository;
            List<User> usuarios = userRepository.findAll();

            // Retorna a lista com o status 200 OK
            return ResponseEntity.ok(usuarios);
    }
}