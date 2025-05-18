package com.jpacourse.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Enumerated(EnumType.STRING)
	private MedicalTreatmentType type;

	@OneToMany(mappedBy = "medicalTreatment", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<VisitEntity> visits;
}
