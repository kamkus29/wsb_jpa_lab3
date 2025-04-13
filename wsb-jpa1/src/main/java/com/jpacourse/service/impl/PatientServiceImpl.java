package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpacourse.rest.exception.EntityNotFoundException;



import jakarta.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public PatientTO findById(Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException("Patient not found");
        }
        return PatientMapper.mapToTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        PatientEntity entity = patientDao.findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException("Patient not found");
        }
        patientDao.delete(entity);
    }
}

