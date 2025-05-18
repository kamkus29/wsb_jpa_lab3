package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PatientVersioningTest {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    @Transactional
    public void shouldDetectOptimisticLockingConflict() {
        EntityManager em1 = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        em1.getTransaction().begin();
        AddressEntity address = AddressEntity.builder()
                .addressLine1("ul. Przykładowa 1")
                .city("Wrocław")
                .postalCode("50-100")
                .build();
        em1.persist(address);
        em1.getTransaction().commit();

        PatientEntity patient = PatientEntity.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .pesel("12345678901")
                .patientNumber("P123")
                .telephoneNumber("123456789")
                .email("jan@example.com")
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .insured(true)
                .address(address)
                .build();

        em1.getTransaction().begin();
        em1.persist(patient);
        em1.getTransaction().commit();

        PatientEntity p1 = em1.find(PatientEntity.class, patient.getId());
        PatientEntity p2 = em2.find(PatientEntity.class, patient.getId());

        em1.getTransaction().begin();
        p1.setFirstName("Zmieniony");
        em1.getTransaction().commit();

        em2.getTransaction().begin();
        p2.setLastName("Konflikt");

        assertThrows(RollbackException.class, () -> {
            em2.merge(p2);
            em2.getTransaction().commit();
        });

        em1.close();
        em2.close();
    }
}
