package org.jala.university.utils;

import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.dto.LoanRequirementsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class ValidateRequirementsTest {
    @Test
    @DisplayName("Should return false if the score is less than 700")
    public void validateRequirementsCase1() {
        BigDecimal income = new BigDecimal(2500);
        BigDecimal loanAmount = new BigDecimal(50000);
        BigDecimal debt = new BigDecimal(700);
        BigDecimal score = new BigDecimal(300);
        int loanTerm = 36;
        UUID userId = UUID.randomUUID();

        LoanRequirementsDTO requirementsDTO = new LoanRequirementsDTO(income, loanAmount, debt, score, loanTerm, userId);

        LoanRequirements newLoanRequirements = new LoanRequirements(requirementsDTO);

        boolean scoreIsBiggerThan700 = ValidateRequirements.exec(newLoanRequirements);

        Assertions.assertFalse(scoreIsBiggerThan700);
    }

    @Test
    @DisplayName("Should return false if the current debt dont compatible with income")
    public void validateRequirementsCase2() {
        BigDecimal income = new BigDecimal(2500);
        BigDecimal loanAmount = new BigDecimal(50000);
        BigDecimal debt = new BigDecimal(2500);
        BigDecimal score = new BigDecimal(820);
        int loanTerm = 36;
        UUID userId = UUID.randomUUID();

        LoanRequirementsDTO requirementsDTO = new LoanRequirementsDTO(income, loanAmount, debt, score, loanTerm, userId);

        LoanRequirements newLoanRequirements = new LoanRequirements(requirementsDTO);

        boolean debtIsIncompatibleWithIncome = ValidateRequirements.exec(newLoanRequirements);

        Assertions.assertFalse(debtIsIncompatibleWithIncome);
    }
}
