package com.jpacourse.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime time;

	private LocalDateTime visitDate;

	private String description;

	@ManyToOne(optional = false)
	private PatientEntity patient;

	@ManyToOne(optional = false)
	private DoctorEntity doctor;

	@ManyToOne(optional = false)
	private MedicalTreatmentEntity medicalTreatment;
}
