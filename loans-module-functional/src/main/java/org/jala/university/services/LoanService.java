/**
 * Service class for managing Loan entities.
 * The LoanService provides methods for retrieving, creating, and deleting loans.
 * It also includes logic to check loan eligibility based on loan requirements.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-19
 */
package org.jala.university.services;

import org.jala.university.domain.entities.Loan;
import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.domain.entities.LoanType;
import org.jala.university.domain.entities.User;
import org.jala.university.domain.repositories.LoanRepository;
import org.jala.university.domain.repositories.LoanTypeRepository;
import org.jala.university.dto.LoanDTO;
import org.jala.university.utils.Interest;
import org.jala.university.utils.ValidateRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {
    /**
     * The repository for accessing and managing Loan entities.
     */
    private final LoanRepository repository;

    /**
     * The service for managing User entities.
     */
    private final UserService userService;

    /**
     * The service for managing LoanRequirements entities.
     */
    private final LoanRequirementsService requirementsService;

    /**
     * The repository for managing LoanRequirements entities.
     */
    private final LoanTypeRepository loanTypeRepository;

    /**
     * Constructor for LoanService.
     *
     * @param repository           The repository for Loan entities.
     * @param userService          The service for User entities.
     */
    @Autowired
    public LoanService(LoanRepository repository, UserService userService, LoanRequirementsService requirementsService, LoanTypeRepository loanTypeRepository) {
        this.repository = repository;
        this.userService = userService;
        this.requirementsService = requirementsService;
        this.loanTypeRepository = loanTypeRepository;
    }

    /**
     * Retrieves a Loan by its unique identifier.
     *
     * @param id The unique identifier of the Loan.
     * @return The Loan if found, otherwise null.
     */
    public Loan getLoanById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public List<Loan> getLoansByUserId(UUID userId) {
        return repository.findLoansByUserId(userId);
    }

    /**
     * Creates a new Loan entity based on the provided data.
     * Checks loan eligibility based on loan requirements before creating.
     *
     * @param data The data to create the Loan entity.
     * @return The newly created Loan entity if eligible, otherwise null.
     */
    public Loan createLoan(LoanDTO data) throws Exception {
        User user = this.userService.getById(data.userId());
        LoanRequirements requirements = this.requirementsService.getById(data.loanRequirementsId());
        LoanType type = this.loanTypeRepository.findById(data.typeId()).orElse(null);
        double monthlyInterestRate = 6.96 / 100 / 12;
        Interest interest = new Interest(requirements.getRequestedAmount(), type, monthlyInterestRate);
        boolean isAllowed = ValidateRequirements.exec(requirements);

        if (!isAllowed) {
            throw new IllegalArgumentException("Loan application not accepted.");
        }

        Loan newLoan = new Loan(data);
        newLoan.setInterest(interest.calculateInterest(data.term()));
        newLoan.setApprovalDate(LocalDate.now());
        newLoan.setUser(user);
        newLoan.setLoanRequirements(requirements);
        newLoan.setType(type);

        return repository.save(newLoan);
    }

    /**
     * Deletes a Loan by its unique identifier.
     *
     * @param id The unique identifier of the Loan to delete.
     */
    public void deleteLoan(UUID id) {
        repository.deleteById(id);
    }
}
