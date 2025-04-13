package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime dateTime, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        MedicalTreatmentEntity treatment = entityManager.createQuery(
                        "SELECT m FROM MedicalTreatmentEntity m", MedicalTreatmentEntity.class)
                .setMaxResults(1)
                .getSingleResult(); // Możesz tu później doprecyzować jaką procedurę przypisać

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(dateTime);
        visit.setDescription(description);
        visit.setMedicalTreatment(treatment);

        patient.getVisits().add(visit);
        entityManager.merge(patient); // Kaskadowe zapisanie wizyty
    }
}
