/**
 * A Data Transfer Object (DTO) representing information for creating a loan.
 * The LoanDTO includes details such as loan amount, interest rate, term, loan type,
 * and the user identifier to associate the loan with a specific user.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university.dto;

import org.jala.university.domain.entities.LoanType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record LoanDTO(
        BigDecimal amount,
        int term,
        UUID userId,
        UUID typeId,
        UUID loanRequirementsId
) {
    // This record automatically generates the constructor and accessor methods.
}