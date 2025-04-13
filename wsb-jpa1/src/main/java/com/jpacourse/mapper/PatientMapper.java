package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitInPatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

import com.jpacourse.dto.VisitInPatientTO;


public class PatientMapper {

    public static PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) return null;

        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        to.setIsInsured(entity.getIsInsured());

        List<VisitInPatientTO> visitsTO = new ArrayList<>();
        if (entity.getVisits() != null) {
            for (VisitEntity visit : entity.getVisits()) {
                VisitInPatientTO vto = new VisitInPatientTO();
                vto.setTime(visit.getTime());
                vto.setDescription(visit.getDescription());
                vto.setDoctorFullName(
                        visit.getDoctor().getFirstName() + " " + visit.getDoctor().getLastName()
                );
                vto.setTreatmentType(visit.getMedicalTreatment().getType().toString());
                visitsTO.add(vto);
            }
        }
        to.setVisits(visitsTO);

        return to;
    }
}
