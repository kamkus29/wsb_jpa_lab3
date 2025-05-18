package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    void compareSelectVsJoin() {
        List<PatientEntity> patients = patientDao.findAll();

        for (PatientEntity patient : patients) {
            System.out.println("== Pacjent: " + patient.getLastName());
            System.out.println("== Liczba wizyt: " + patient.getVisits().size());
        }
    }
}
