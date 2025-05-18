package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDaoCustom;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime dateTime, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        MedicalTreatmentEntity treatment = entityManager.createQuery(
                        "SELECT m FROM MedicalTreatmentEntity m", MedicalTreatmentEntity.class)
                .setMaxResults(1)
                .getSingleResult();

        VisitEntity visit = VisitEntity.builder()
                .description(description)
                .patient(patient)
                .doctor(doctor)
                .medicalTreatment(treatment)
                .time(dateTime)
                .visitDate(dateTime)
                .build();

        patient.getVisits().add(visit);
        entityManager.merge(patient);
    }

    @Override
    public List<PatientEntity> findAllWithVisitsJoinFetch() {
        return entityManager.createQuery(
                "SELECT DISTINCT p FROM PatientEntity p LEFT JOIN FETCH p.visits", PatientEntity.class
        ).getResultList();
    }
}
