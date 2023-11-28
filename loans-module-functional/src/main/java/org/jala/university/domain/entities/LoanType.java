package org.jala.university.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.jala.university.dto.LoanTypeDTO;

import java.util.List;
import java.util.UUID;

@Entity(name = "loan_type")
@Table(name = "loan_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

//    @JsonIgnoreProperties("type")
//    @OneToMany(mappedBy = "type")
//    private List<Loan> loans;

    public LoanType (LoanTypeDTO data) {
        this.title = data.title();
    }
}
