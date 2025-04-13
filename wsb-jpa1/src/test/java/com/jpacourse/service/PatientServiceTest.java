package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void shouldFindPatientByIdWithVisits() {
        // when
        PatientTO patient = patientService.findById(1L);

        // then
        assertNotNull(patient);
        assertEquals("Anna", patient.getFirstName());
        assertTrue(patient.getIsInsured());
        assertEquals(1, patient.getVisits().size());

        var visit = patient.getVisits().get(0);
        assertEquals("Pierwsza wizyta", visit.getDescription());
        assertEquals("Jan Kowalski", visit.getDoctorFullName());
        assertEquals("EKG", visit.getTreatmentType());
    }

    @Test
    public void shouldDeletePatientAndCascadeVisits() {
        // given
        Long patientId = 1L;

        // when
        patientService.delete(patientId);

        // then
        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientService.findById(patientId);
        });

        assertTrue(exception.getMessage().contains("not found"));
    }
}
