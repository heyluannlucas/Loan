package org.jala.university.services;

import org.jala.university.domain.entities.User;
import org.jala.university.domain.repositories.UserRepository;
import org.jala.university.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    public User create(UserDTO data) throws Exception {
        try {
            User newUser = new User(data);
            return this.repository.save(newUser);
        } catch (Exception e) {
            throw new Exception("Não foi possível criar o usuário");
        }
    }

    public List<User> getAll() {
        return this.repository.findAll();
    }
}
