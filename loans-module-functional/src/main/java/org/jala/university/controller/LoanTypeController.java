package org.jala.university.controller;

import org.jala.university.domain.entities.LoanType;
import org.jala.university.domain.repositories.LoanTypeRepository;
import org.jala.university.dto.LoanTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans/types")
public class LoanTypeController {
    private final LoanTypeRepository repository;

    /**
     * Constructs a new LoanTypeController with the provided LoanTypeService.
     *
     * @param repository The LoanTypeRepository to be used by the controller.
     */
    @Autowired
    public LoanTypeController(LoanTypeRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of all loan types.
     *
     * @return A list of LoanType entities.
     */
    @GetMapping
    public ResponseEntity<List<LoanType>> getAllLoanTypes() {
        List<LoanType> types = repository.findAll();
        return ResponseEntity.ok(types);
    }

    /**
     * Retrieves a specific loan type by its unique identifier.
     *
     * @param id The unique identifier of the loan type.
     * @return ResponseEntity containing the found LoanType or a not found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LoanType> getLoanTypeById(@PathVariable UUID id) {
        Optional<LoanType> loanTypeOptional = repository.findById(id);

        return loanTypeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoanType> create(@RequestBody LoanTypeDTO data) {
        LoanType newLoanType = new LoanType(data);

        LoanType createdType = this.repository.save(newLoanType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType);
    }
}

