/**
 * Utility class for validating loan requirements.
 * The ValidateRequirements class provides a method to check if a loan is allowed based on specified requirements.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-20
 */
package org.jala.university.utils;

import org.jala.university.domain.entities.LoanRequirements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidateRequirements {
    /**
     * Validates loan requirements to determine if a loan is allowed.
     *
     * @param requirements The LoanRequirements object containing the loan requirements.
     * @return true if the loan is allowed, otherwise false.
     */
    public static boolean exec(LoanRequirements requirements) {
        BigDecimal income = requirements.getIncome();
        BigDecimal currentDebt = requirements.getCurrentDebt();
        BigDecimal creditScore = requirements.getCreditScore();
        BigDecimal requestedLoanAmount = requirements.getRequestedAmount();
        int term = requirements.getTerm();

        // Calculate debt-to-income ratio
        BigDecimal debtToIncomeRatio = currentDebt.divide(income, 2, RoundingMode.HALF_UP);

        // Check conditions for loan eligibility
        boolean scoreIsBiggerThan700 = creditScore.compareTo(BigDecimal.valueOf(700)) >= 0;
        boolean debtIsLessThan400 = debtToIncomeRatio.compareTo(BigDecimal.valueOf(0.4)) <= 0;

        if (debtIsLessThan400 && scoreIsBiggerThan700) {
            // Calculate monthly payment
            double monthlyPayment = calculateMonthlyPayment(requestedLoanAmount, term);
            return income.compareTo(BigDecimal.valueOf(monthlyPayment)) > 0;
        }

        return false;
    }

    /**
     * Calculates the monthly payment for a loan.
     *
     * @param loanAmount The loan amount.
     * @param loanTerm   The loan term in months.
     * @return The calculated monthly payment.
     */
    private static double calculateMonthlyPayment(BigDecimal loanAmount, int loanTerm) {
        double monthlyInterestRate = 6.96 / 100 / 12;

        double numerator = loanAmount.doubleValue() * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm));
        double denominator = Math.pow(1 + monthlyInterestRate, loanTerm) - 1;

        return numerator / denominator;
    }
}
