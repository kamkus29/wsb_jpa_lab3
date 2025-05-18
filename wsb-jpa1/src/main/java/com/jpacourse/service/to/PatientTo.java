package com.jpacourse.service.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientTo {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private boolean insured;
}
