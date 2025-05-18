package com.jpacourse.mapper;

import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.to.VisitTo;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {
    public VisitTo mapToTo(VisitEntity entity) {
        if (entity == null) return null;
        return VisitTo.builder()
                .id(entity.getId())
                .visitDate(entity.getVisitDate())
                .doctorId(entity.getDoctor().getId())
                .patientId(entity.getPatient().getId())
                .treatmentId(entity.getMedicalTreatment().getId())
                .build();
    }

    public VisitEntity mapToEntity(VisitTo to) {
        if (to == null) return null;
        return VisitEntity.builder()
                .id(to.getId())
                .visitDate(to.getVisitDate())
                .build();
    }
}
