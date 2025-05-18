package com.jpacourse.service;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.List;

public interface PatientService {
    List<VisitEntity> findAllVisitsByPatientId(Long patientId);
    List<PatientEntity> findAll();
    List<PatientEntity> findAllWithVisits();
}
