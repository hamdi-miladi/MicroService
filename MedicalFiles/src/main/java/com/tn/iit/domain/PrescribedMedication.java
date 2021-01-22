package com.tn.iit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PrescribedMedication {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "medication_id")
	private Integer medicationId;

	@DecimalMin("0.01")
	@Column(name = "unit_price")
	private float unitPrice;

	@ManyToOne
	@JoinColumn(name = "medical_file", referencedColumnName = "id")
	@NotNull
	private MedicalFile medicalFile;

	public PrescribedMedication() {
		super();
	}

	public PrescribedMedication(Integer medicationId, @DecimalMin("0.01") float unitPrice, MedicalFile medicalFile) {
		super();
		this.medicationId = medicationId;
		this.unitPrice = unitPrice;
		this.medicalFile = medicalFile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public MedicalFile getMedicalFile() {
		return medicalFile;
	}

	public void setMedicalFile(MedicalFile medicalFile) {
		this.medicalFile = medicalFile;
	}

}
