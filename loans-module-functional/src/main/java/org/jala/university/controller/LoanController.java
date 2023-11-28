/**
 * Controller class for managing Loan entities through RESTful API endpoints.
 * The endpoints include operations such as retrieving all loans, retrieving a loan by ID,
 * creating a new loan, and deleting a loan.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university.controller;

import org.jala.university.domain.entities.Loan;
import org.jala.university.dto.LoanDTO;
import org.jala.university.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    /**
     * Constructs a new LoanController with the provided LoanService.
     *
     * @param service The LoanService to be used by the controller.
     */
    @Autowired
    public LoanController(LoanService service) {
        this.service = service;
    }


    /**
     * Retrieves a list of all loans.
     *
     * @return A list of Loan entities.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable UUID userId) {
        try {
            List<Loan> loans = this.service.getLoansByUserId(userId);
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves a specific loan by its ID.
     *
     * @param id The unique identifier of the loan.
     * @return ResponseEntity containing the found Loan or a not found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable UUID id) {
        Loan loan = service.getLoanById(id);
        return loan != null ? ResponseEntity.ok(loan) : ResponseEntity.notFound().build();
    }

    /**
     * Creates a new loan based on the provided LoanDTO.
     *
     * @param data The LoanDTO containing information for the new loan.
     * @return ResponseEntity containing the created Loan.
     */
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody LoanDTO data) throws Exception {
        Loan newLoan = service.createLoan(data);
        return ResponseEntity.ok(newLoan);
    }

    /**
     * Deletes a loan with the specified ID.
     *
     * @param id The unique identifier of the loan to be deleted.
     * @return ResponseEntity indicating the success of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable UUID id) {
        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
