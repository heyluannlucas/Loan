/**
 * Repository interface for accessing and managing Loan entities in the database.
 * Extends JpaRepository to inherit common CRUD operations.
 * The repository is specifically designed for the Loan entity, using UUID as the identifier.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-18
 */
package org.jala.university.domain.repositories;

import org.jala.university.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
    List<Loan> findLoansByUserId(UUID id);
}
