/**
 * Repository interface for accessing and managing LoanRequirements entities in the database.
 * Extends JpaRepository to inherit common CRUD operations.
 * The repository is specifically designed for the LoanRequirements entity, using UUID as the identifier.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university.domain.repositories;

import org.jala.university.domain.entities.LoanRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRequirementsRepository extends JpaRepository<LoanRequirements, UUID> {}
