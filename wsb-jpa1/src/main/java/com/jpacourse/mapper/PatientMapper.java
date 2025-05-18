package com.jpacourse.mapper;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.to.PatientTo;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientTo mapToTo(PatientEntity entity) {
        if (entity == null) return null;
        return PatientTo.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .pesel(entity.getPesel())
                .isInsured(entity.isInsured())
                .build();
    }

    public PatientEntity mapToEntity(PatientTo to) {
        if (to == null) return null;
        return PatientEntity.builder()
                .id(to.getId())
                .firstName(to.getFirstName())
                .lastName(to.getLastName())
                .pesel(to.getPesel())
                .Insured(to.isInsured())
                .build();
    }
}
