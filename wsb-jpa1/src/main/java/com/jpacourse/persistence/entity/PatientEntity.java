package com.jpacourse.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String patientNumber;
	private String firstName;
	private String lastName;
	private String pesel;
	private String email;
	private String telephoneNumber;
	private LocalDate dateOfBirth;


	private boolean Insured;


	@ManyToOne(optional = false)
	private AddressEntity address;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VisitEntity> visits;
}
