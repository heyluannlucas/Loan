/**
 * A class representing a financial interest calculation.
 * This class calculates the interest for a given loan amount, loan type, and interest rate.
 * It can also generate a payment schedule based on the number of installments and grace period days.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-10
 */
package org.jala.university.utils;

import lombok.Getter;
import org.jala.university.domain.entities.LoanType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Getter
public class Interest {
    /**
     * -- GETTER --
     *  Gets the loan amount.
     *
     */
    private BigDecimal loanAmount;
    /**
     * -- GETTER --
     *  Gets the loan type.
     *
     */
    private LoanType loanType;
    /**
     * -- GETTER --
     *  Gets the interest rate.
     *
     */
    private double interestRate;

    /**
     * Constructs an Interest object with the provided loan amount, loan type, and interest rate.
     *
     * @param loanAmount   The loan amount, must be greater than zero.
     * @param loanType     The type of loan.
     * @param interestRate The interest rate, must not be negative.
     */
    public Interest(BigDecimal loanAmount, LoanType loanType, double interestRate) {
        setLoanAmount(loanAmount);
        setLoanType(loanType);
        setInterestRate(interestRate);
    }

    /**
     * Sets the loan amount.
     *
     * @param loanAmount The loan amount, must be greater than zero.
     * @throws IllegalArgumentException if the loan amount is not greater than zero.
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        if (loanAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        this.loanAmount = loanAmount;
    }

    /**
     * Sets the loan type.
     *
     * @param loanType The type of loan.
     */
    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    /**
     * Sets the interest rate.
     *
     * @param interestRate The interest rate, must not be negative.
     * @throws IllegalArgumentException if the interest rate is negative.
     */
    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    }

    /**
     * Calculates the interest for the loan.
     *
     * @return The calculated interest as a BigDecimal.
     */
    public BigDecimal calculateInterest(int term) {
        return loanAmount.multiply(BigDecimal.valueOf(interestRate * term));
    }

    /**
     * Generates a payment schedule for the loan.
     *
     * @param numInstallments   The number of installments in the payment schedule.
     * @param gracePeriodDays   The grace period in days.
     * @return A list of strings representing the payment schedule.
     */
    public List<String> generatePaymentSchedule(int numInstallments, int gracePeriodDays) {
        return PaymentScheduleGenerator.generatePaymentSchedule(this, numInstallments, gracePeriodDays);
    }
}
