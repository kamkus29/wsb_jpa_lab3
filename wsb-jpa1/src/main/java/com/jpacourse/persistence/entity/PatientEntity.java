	package com.jpacourse.persistence.entity;

	import jakarta.persistence.*;
	import lombok.*;

	import java.time.LocalDate;
	import java.util.List;

	@Entity
	@Table(name = "patient_entity")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class PatientEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Version
		private Long version;

		private String firstName;
		private String lastName;
		private String email;
		private String pesel;
		private String telephoneNumber;
		private String patientNumber;
		private LocalDate dateOfBirth;
		private boolean insured;

		@ManyToOne(optional = false)
		private AddressEntity address;

		@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
		private List<VisitEntity> visits;
	}
