package com.jpacourse.service;

import com.jpacourse.service.to.PatientTo;
import com.jpacourse.persistence.entity.VisitEntity;


import java.util.List;

public interface PatientService {
    List<PatientTo> findByLastName(String lastName);
    List<VisitEntity> findAllVisitsByPatientId(Long patientId);

}
