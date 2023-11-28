/**
 * Service class for managing LoanRequirements entities.
 * The LoanRequirementsService provides methods for retrieving, creating, and deleting
 * loan requirements. It also includes a method to check if a loan is allowed based on
 * validation rules.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-19
 */
package org.jala.university.services;

import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.domain.entities.User;
import org.jala.university.domain.repositories.LoanRequirementsRepository;
import org.jala.university.dto.LoanRequirementsDTO;
import org.jala.university.utils.ValidateRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanRequirementsService {
    /**
     * The repository for accessing and managing LoanRequirements entities.
     */
    private final LoanRequirementsRepository repository;

    private final UserService userService;

    /**
     * Constructor for LoanRequirementsService.
     *
     * @param repository The repository for LoanRequirements entity.
     * @param userService The service for User entity
     */
    @Autowired
    public LoanRequirementsService(LoanRequirementsRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    /**
     * Retrieves LoanRequirements by its unique identifier.
     *
     * @param id The unique identifier of the LoanRequirements.
     * @return The LoanRequirements if found, otherwise null.
     */
    public LoanRequirements getById(UUID id) throws Exception {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception("Não foi possível pegar o requirement");
        }
    }

    /**
     * Retrieves all LoanRequirements entities.
     *
     * @return A list of all LoanRequirements entities.
     */
    public List<LoanRequirements> getAllRequirements() {
        List<LoanRequirements> requirements = repository.findAll();
        System.out.println("Total requirements: " + requirements.size());
        return requirements;
    }

    /**
     * Creates a new LoanRequirements entity based on the provided data.
     *
     * @param data The data to create the LoanRequirements entity.
     * @return The newly created LoanRequirements entity.
     */
    public LoanRequirements create(LoanRequirementsDTO data) throws Exception {
        try {
            User user = this.userService.getById(data.userId());

            LoanRequirements newRequirement = new LoanRequirements(data);
            newRequirement.setUser(user);

            return repository.save(newRequirement);
        } catch (Exception e) {
            throw new Exception("Não foi possivel criar " + e.getMessage());
        }
    }

    /**
     * Deletes LoanRequirements by its unique identifier.
     *
     * @param id The unique identifier of the LoanRequirements to delete.
     */
    public void deleteRequirements(UUID id) {
        this.repository.deleteById(id);
    }
}
