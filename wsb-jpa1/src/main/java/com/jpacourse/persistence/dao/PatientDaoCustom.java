package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDaoCustom {

    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime dateTime, String description);

    List<PatientEntity> findAllWithVisitsJoinFetch();
}
