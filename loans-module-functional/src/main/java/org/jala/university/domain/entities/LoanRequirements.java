/**
 * Entity class representing loan requirements within the application.
 * LoanRequirements include details such as income, requested loan amount,
 * current debt, credit score, term, and a list of associated loans.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-19
 */
package org.jala.university.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.jala.university.dto.LoanRequirementsDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "loan_requirements")
@Table(name = "loan_requirements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LoanRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * The requested loan amount associated with the loan requirements.
     */
    @Column(name = "requested_amount", nullable = false)
    private BigDecimal requestedAmount;

    /**
     * The term (duration) associated with the loan requirements.
     */
    @Column(nullable = false)
    private int term;

    /**
     * The income associated with the loan requirements.
     */
    @Column(nullable = false)
    private BigDecimal income;

    /**
     * The current debt associated with the loan requirements.
     */
    @Column(name = "current_debt", nullable = false)
    private BigDecimal currentDebt;

    /**
     * The credit score associated with the loan requirements.
     */
    @Column(name = "credit_score", nullable = false)
    private BigDecimal creditScore;

    /**
     * The user associated with the loan requirement.
     */
    @JsonIgnoreProperties("loanRequirements")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * The loan associated with the loan requirements.
     */
//    @JsonIgnoreProperties("loanRequirements")
//    @OneToOne(mappedBy = "loanRequirements")
//    private Loan loan;

    /**
     * Constructs LoanRequirements entity with the provided LoanRequirementsDTO data.
     *
     * @param data The LoanRequirementsDTO containing information for the loan requirements.
     */
    public LoanRequirements(LoanRequirementsDTO data) {
        this.income = data.income();
        this.requestedAmount = data.requestedAmount();
        this.currentDebt = data.currentDebt();
        this.creditScore = data.creditScore();
        this.term = data.term();
    }
}
