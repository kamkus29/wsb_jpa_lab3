package com.jpacourse.service.impl;

import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import com.jpacourse.service.to.PatientTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final VisitDao visitDao;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientTo> findByLastName(String lastName) {
        return patientDao.findByLastName(lastName)
                .stream()
                .map(patientMapper::mapToTo)
                .toList();
    }

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId);
    }
}
