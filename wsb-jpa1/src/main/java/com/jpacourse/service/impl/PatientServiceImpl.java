package com.jpacourse.service.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final VisitDao visitDao;

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId);
    }

    @Override
    public List<PatientEntity> findAll() {
        return patientDao.findAll();
    }

    @Override
    public List<PatientEntity> findAllWithVisits() {
        return patientDao.findAllWithVisitsJoinFetch();
    }
}
