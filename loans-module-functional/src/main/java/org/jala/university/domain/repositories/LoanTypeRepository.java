package org.jala.university.domain.repositories;

import org.jala.university.domain.entities.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanTypeRepository extends JpaRepository<LoanType, UUID> {
}
