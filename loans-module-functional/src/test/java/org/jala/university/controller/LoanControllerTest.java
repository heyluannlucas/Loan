package org.jala.university.controller;


import org.jala.university.domain.entities.Loan;
import org.jala.university.services.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class LoanControllerTest {

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLoanById() {

        UUID loanId = UUID.randomUUID();
        Loan loan = new Loan();
        when(loanService.getLoanById(loanId)).thenReturn(loan);

        ResponseEntity<Loan> responseEntity = loanController.getLoanById(loanId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loan, responseEntity.getBody());
    }

    @Test
    void testGetLoanByIdNotFound() {
        UUID loanId = UUID.randomUUID();
        when(loanService.getLoanById(loanId)).thenReturn(null);

        ResponseEntity<Loan> responseEntity = loanController.getLoanById(loanId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    void testDeleteLoan() {
        UUID loanId = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = loanController.deleteLoan(loanId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(loanService, times(1)).deleteLoan(loanId);
    }
}
