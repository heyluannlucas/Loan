package org.jala.university.services;

import org.jala.university.domain.entities.Loan;
import org.jala.university.domain.repositories.LoanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {

    @Mock
    private LoanRepository repository;

    @InjectMocks
    private LoanService service;

    @Test
    public void testGetLoanById() {
        UUID id = UUID.randomUUID();
        Loan loan = new Loan();
        when(repository.findById(id)).thenReturn(Optional.of(loan));

        Loan retrievedLoan = service.getLoanById(id);

        assertEquals(loan, retrievedLoan);
    }

    @Test
    public void testDeleteLoan() {
        UUID id = UUID.randomUUID();
        service.deleteLoan(id);

        verify(repository, times(1)).deleteById(id);
    }
}
