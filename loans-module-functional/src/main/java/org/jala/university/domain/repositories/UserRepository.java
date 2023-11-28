package org.jala.university.domain.repositories;

import org.jala.university.domain.entities.Loan;
import org.jala.university.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
