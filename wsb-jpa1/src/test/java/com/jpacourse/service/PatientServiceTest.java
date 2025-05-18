package com.jpacourse.service;

import com.jpacourse.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void shouldCompareSelectVsJoinFetch() {
        // JOIN FETCH – wczytuje visits w jednej sesji
        long startJoin = System.nanoTime();
        List<PatientEntity> joinPatients = patientService.findAllWithVisits();
        joinPatients.forEach(p -> p.getVisits().size()); // działa, bo visits są już załadowane
        long endJoin = System.nanoTime();

        // LAZY SELECT – sesja zamknięta, więc nie próbujemy odczytywać visits
        long startSelect = System.nanoTime();
        List<PatientEntity> selectPatients = patientService.findAll();
        long endSelect = System.nanoTime();

        long selectDuration = (endSelect - startSelect) / 1_000_000;
        long joinDuration = (endJoin - startJoin) / 1_000_000;

        System.out.println("SELECT only (lazy): " + selectDuration + " ms");
        System.out.println("JOIN FETCH (visits eager): " + joinDuration + " ms");

        assertThat(selectPatients).hasSize(joinPatients.size());
    }
}
