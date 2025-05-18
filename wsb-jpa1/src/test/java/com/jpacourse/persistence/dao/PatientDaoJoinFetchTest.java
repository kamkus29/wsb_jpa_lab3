package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoJoinFetchTest {

    @Autowired
    private PatientDao patientDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void shouldLoadVisitsUsingLazyFetching() {
        List<PatientEntity> patients = patientDao.findAll();
        assertThat(patients).isNotEmpty();

        for (PatientEntity patient : patients) {
            assertThat(Hibernate.isInitialized(patient.getVisits())).isFalse(); // Lazy
        }
    }

    @Test
    @Transactional
    public void shouldLoadVisitsUsingJoinFetch() {
        List<PatientEntity> patients = ((PatientDaoCustom) patientDao).findAllWithVisitsJoinFetch();
        assertThat(patients).isNotEmpty();

        for (PatientEntity patient : patients) {
            assertThat(Hibernate.isInitialized(patient.getVisits())).isTrue(); // JOIN FETCH
        }
    }
}

/*
 * Wnioski z porównania FetchMode.SELECT vs FetchMode.JOIN:
 *
 * 1. FetchMode.SELECT (przy FetchType.EAGER):
 *    - Dane pacjentów są pobierane jednym zapytaniem.
 *    - Wizyty są pobierane osobnymi zapytaniami (tzw. N+1 problem).
 *    - Dla każdego pacjenta wykonywane jest dodatkowe zapytanie SQL do tabeli VISIT_ENTITY.
 *    - Jest to mniej wydajne przy dużej liczbie encji i relacji.
 *
 * 2. FetchMode.JOIN:
 *    - Pacjenci i ich wizyty są pobierane jednym zapytaniem z użyciem JOIN.
 *    - Mniejsze obciążenie bazy danych – mniej zapytań SQL.
 *    - Bardziej wydajne, ale może skutkować duplikacją danych w wynikach (np. ten sam pacjent wielokrotnie, jeśli ma wiele wizyt).
 *
 * Podsumowanie:
 * JOIN FETCH zalecany, gdy od razu potrzebujemy danych z relacji, szczególnie przy wielu encjach.
 * SELECT lepszy, gdy nie zawsze potrzebujemy danych z relacji – daje większą elastyczność.
 */
