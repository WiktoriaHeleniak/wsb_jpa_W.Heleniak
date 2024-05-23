package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;


	@Column(name = "TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	@ManyToMany(mappedBy = "treatments")
	private Set<VisitEntity> visits = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public void setVisits(Set<VisitEntity> visits) {
		this.visits = visits;
	}

	public Set<VisitEntity> getVisits() {
		return visits;
	}
}
