package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PatientDaoImplTest {

    @Autowired
    private PatientDao patientDao;


    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void shouldAddVisitToPatient() {
        // given
        Long patientId = 1L;
        Long doctorId = 1L;
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 15, 12, 0);
        String description = "Testowa wizyta";

        // when
        patientDao.addVisitToPatient(patientId, doctorId, dateTime, description);

        // then
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        assertNotNull(patient);
        assertFalse(patient.getVisits().isEmpty());

        VisitEntity visit = patient.getVisits().get(patient.getVisits().size() - 1);
        assertEquals(description, visit.getDescription());
        assertEquals(dateTime, visit.getTime());
        assertEquals(doctorId, visit.getDoctor().getId());
    }
}
