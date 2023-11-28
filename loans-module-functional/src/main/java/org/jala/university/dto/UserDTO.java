package org.jala.university.dto;

public record UserDTO(String name, String surname, String register, String email) {
    // This record automatically generates the constructor and accessor methods.
}
