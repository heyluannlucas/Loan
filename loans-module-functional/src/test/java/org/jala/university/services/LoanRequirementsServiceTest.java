package org.jala.university.services;

import org.jala.university.domain.entities.LoanRequirements;
import org.jala.university.domain.entities.User;
import org.jala.university.domain.repositories.LoanRequirementsRepository;
import org.jala.university.dto.LoanRequirementsDTO;
import org.jala.university.utils.ValidateRequirements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanRequirementsServiceTest {

    @Mock
    private LoanRequirementsRepository loanRequirementsRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private LoanRequirementsService loanRequirementsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_ExistingId_ReturnsLoanRequirements() throws Exception {
        UUID existingId = UUID.randomUUID();
        LoanRequirements mockLoanRequirements = new LoanRequirements();
        when(loanRequirementsRepository.findById(existingId)).thenReturn(Optional.of(mockLoanRequirements));

        LoanRequirements result = loanRequirementsService.getById(existingId);

        assertNotNull(result);
        assertEquals(mockLoanRequirements, result);
    }

    @Test
    void deleteRequirements_ExistingId_DeletesLoanRequirements() {
        UUID existingId = UUID.randomUUID();

        loanRequirementsService.deleteRequirements(existingId);

        verify(loanRequirementsRepository, times(1)).deleteById(existingId);
    }
}
