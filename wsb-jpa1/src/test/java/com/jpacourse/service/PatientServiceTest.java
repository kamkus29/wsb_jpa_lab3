package com.jpacourse.service;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PatientServiceTest {

    @Mock
    private PatientDao patientDao;

    @Mock
    private VisitDao visitDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    private PatientEntity patient;
    private VisitEntity visit;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        AddressEntity address = AddressEntity.builder()
                .addressLine1("ul. Testowa 1")
                .addressLine2("m. 12")
                .city("Warszawa")
                .postalCode("00-001")
                .build();

        patient = PatientEntity.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jan.kowalski@example.com")
                .telephoneNumber("123456789")
                .patientNumber("P123")
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .Insured(true)
                .address(address)
                .build();

        visit = VisitEntity.builder()
                .description("Wizyta testowa")
                .time(LocalDateTime.now())
                .patient(patient)
                .build();
    }

    @Test
    public void shouldFindVisitsByPatientId() {
        when(visitDao.findAllByPatientId(1L)).thenReturn(Collections.singletonList(visit));

        List<VisitEntity> result = patientService.findAllVisitsByPatientId(1L);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getDescription()).isEqualTo("Wizyta testowa");
    }
}
