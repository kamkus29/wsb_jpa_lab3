package com.jpacourse.service;

import com.jpacourse.service.to.VisitTo;

import java.util.List;

public interface VisitService {
    List<VisitTo> findAllByPatientId(Long patientId);
}
