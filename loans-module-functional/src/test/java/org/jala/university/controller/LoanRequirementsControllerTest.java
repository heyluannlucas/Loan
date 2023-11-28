package org.jala.university.controller;

import org.jala.university.controller.LoanRequirementsController;
import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.dto.LoanRequirementsDTO;
import org.jala.university.services.LoanRequirementsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class LoanRequirementsControllerTest {

    @Mock
    private LoanRequirementsService loanRequirementsService;

    @InjectMocks
    private LoanRequirementsController loanRequirementsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLoanRequirementsById() throws Exception {
        // Arrange
        UUID requirementsId = UUID.randomUUID();
        LoanRequirements requirements = new LoanRequirements();
        when(loanRequirementsService.getById(requirementsId)).thenReturn(requirements);

        // Act
        ResponseEntity<LoanRequirements> responseEntity = loanRequirementsController.getLoanById(requirementsId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(requirements, responseEntity.getBody());
    }

    @Test
    void testGetLoanRequirementsByIdNotFound() throws Exception {
        // Arrange
        UUID requirementsId = UUID.randomUUID();
        when(loanRequirementsService.getById(requirementsId)).thenReturn(null);

        // Act
        ResponseEntity<LoanRequirements> responseEntity = loanRequirementsController.getLoanById(requirementsId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

}
