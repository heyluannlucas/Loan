/**
 * Controller class for managing LoanRequirements entities through RESTful API endpoints.
 * The endpoints include operations such as retrieving loan requirements by ID and
 * inserting new loan requirements.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university.controller;

import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.dto.LoanRequirementsDTO;
import org.jala.university.services.LoanRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/requirements")
public class LoanRequirementsController {
    private final LoanRequirementsService service;

    /**
     * Constructs a new LoanRequirementsController with the provided LoanRequirementsService.
     *
     * @param service The LoanRequirementsService to be used by the controller.
     */
    @Autowired
    public LoanRequirementsController(LoanRequirementsService service) {
        this.service = service;
    }

    /**
     * Retrieves loan requirements by their unique identifier.
     *
     * @param id The unique identifier of the loan requirements.
     * @return ResponseEntity containing the found LoanRequirements or a not found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LoanRequirements> getLoanById(@PathVariable UUID id) throws Exception {
        LoanRequirements requirements = this.service.getById(id);
        return requirements != null ? ResponseEntity.ok(requirements) : ResponseEntity.notFound().build();
    }

    /**
     * Inserts new loan requirements based on the provided LoanRequirementsDTO.
     *
     * @param data The LoanRequirementsDTO containing information for the new requirements.
     * @return ResponseEntity containing the created LoanRequirements.
     */
    @PostMapping
    public ResponseEntity<LoanRequirements> insertRequirements(@RequestBody LoanRequirementsDTO data) throws Exception {
        LoanRequirements newRequirement = service.create(data);
        return ResponseEntity.ok(newRequirement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequirement(@PathVariable UUID id) {
        service.deleteRequirements(id);

        return ResponseEntity.noContent().build();
    }
}
