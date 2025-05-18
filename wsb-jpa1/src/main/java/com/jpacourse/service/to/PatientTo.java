package com.jpacourse.service.to;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientTo {
    private Long id;
    private String patientNumber;
    private String firstName;
    private String lastName;
    private String pesel;
    private String email;
    private String telephoneNumber;
    private LocalDate dateOfBirth;
    private boolean isInsured;
}
