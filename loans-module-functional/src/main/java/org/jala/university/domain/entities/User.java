package org.jala.university.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jala.university.dto.UserDTO;

import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String register;

    @Column(nullable = false, unique = true)
    private String email;

//    @OneToMany(mappedBy = "user")
//    private List<Loan> loans;
//
//    @OneToMany(mappedBy = "user")
//    private List<LoanRequirements> loanRequirements;

    public User(UserDTO data) {
        this.name = data.name();
        this.surname = data.surname();
        this.register = data.register();
        this.email = data.email();
    }
}
