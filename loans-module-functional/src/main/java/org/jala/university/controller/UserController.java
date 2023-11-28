package org.jala.university.controller;

import org.jala.university.domain.entities.User;
import org.jala.university.dto.UserDTO;
import org.jala.university.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    /**
     * Constructs a new UserController with the provided UserService.
     *
     * @param userService The UserService to be used by the controller.
     */

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    /**
     * Retrieves a specific user by its unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return ResponseEntity containing the found User or a not found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = this.service.getById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    /**
     * Saves a new user based on the provided User entity.
     *
     * @param data The User entity to be saved.
     * @return ResponseEntity containing the created User.
     */
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO data) throws Exception {
        User createdUser = this.service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.service.getAll();

        return ResponseEntity.ok(users);
    }
}
