package com.example.LoginUsuario.service;

import com.example.LoginUsuario.dto.UserRequestDTO;
import com.example.LoginUsuario.model.User;
import com.example.LoginUsuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User salvar(UserRequestDTO dto) {

        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password());

        return repository.save(user);
    }
}