package com.jpacourse.service.impl;

import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.service.VisitService;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.service.to.VisitTo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;
    private final VisitMapper visitMapper;

    public VisitServiceImpl(VisitDao visitDao, VisitMapper visitMapper) {
        this.visitDao = visitDao;
        this.visitMapper = visitMapper;
    }

    @Override
    public List<VisitTo> findAllByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId)
                .stream()
                .map(visitMapper::mapToTo)
                .collect(Collectors.toList());
    }
}
