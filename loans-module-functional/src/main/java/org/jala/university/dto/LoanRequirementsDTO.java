/**
 * A Data Transfer Object (DTO) representing information for creating or updating loan requirements.
 * The LoanRequirementsDTO includes details such as income, requested loan amount, current debt,
 * credit score, and term.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-19
 */
package org.jala.university.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record LoanRequirementsDTO(
        BigDecimal income,
        BigDecimal requestedAmount,
        BigDecimal currentDebt,
        BigDecimal creditScore,
        int term, UUID userId
) {
    // This record automatically generates the constructor and accessor methods.
}
