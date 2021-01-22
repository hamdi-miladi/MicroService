package com.tn.iit.dto;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class PrescribedMedicationDTO {

	private Integer id;

	private Integer medicationId;

	@NotNull
	private float unitPrice;

	private String medicationName;
	private String medicationCategory;

	public PrescribedMedicationDTO() {
		super();
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

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getMedicationCategory() {
		return medicationCategory;
	}

	public void setMedicationCategory(String medicationCategory) {
		this.medicationCategory = medicationCategory;
	}

}