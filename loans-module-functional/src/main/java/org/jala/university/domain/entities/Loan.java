/**
 * Entity class representing a Loan within the application.
 * A Loan is associated with specific details such as loan amount, interest rate, term, loan type,
 * and references to related loan requirements.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-19
 */
package org.jala.university.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.jala.university.dto.LoanDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "loans")
@Table(name = "loans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * The loan amount associated with the loan.
     */
    @Column(nullable = false)
    private BigDecimal amount;

    /**
     * The interest rate associated with the loan.
     */
    @Column(nullable = false)
    private BigDecimal interest;

    /**
     * The term (duration) of the loan.
     */
    @Column(nullable = false)
    private int term;

    /**
     * Approve date of the loan.
     */
    @Column(name = "approval_date", nullable = false)
    private LocalDate approvalDate;

    /**
     * The user associated with the loan.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * The type of loan (e.g., personal loan, mortgage).
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private LoanType type;

    /**
     * The loan requirements associated with the loan.
     */
    @OneToOne
    @JoinColumn(name = "loan_requirements_id")
    private LoanRequirements loanRequirements;

    /**
     * Constructs a Loan entity with the provided LoanDTO data.
     *
     * @param data The LoanDTO containing information for the loan.
     */
    public Loan(LoanDTO data) {
        this.amount = data.amount();
        this.term = data.term();
    }
}
