package com.jpacourse.service;

import com.jpacourse.service.to.VisitTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    void shouldReturnVisitsForPatientById() {
        // given
        Long patientId = 1L; // ID zgodne z tym z data.sql

        // when
        List<VisitTo> visits = visitService.findAllByPatientId(patientId);

        // then
        assertThat(visits).isNotEmpty();
        assertThat(visits.get(0).getPatientId()).isEqualTo(patientId);
    }
}
