package com.tn.iit.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.ToString;
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class MedicalFileDTO {
	
	private Integer id;
	
	@Size(min = 1, max = 100)
	private String patientName;

	private LocalDateTime arrivalDate;

	private List<PrescribedMedicationDTO> prescribedMedicationDTO;
	public MedicalFileDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public List<PrescribedMedicationDTO> getPrescribedMedicationDTO() {
		return prescribedMedicationDTO;
	}
	public void setPrescribedMedicationDTO(List<PrescribedMedicationDTO> prescribedMedicationDTO) {
		this.prescribedMedicationDTO = prescribedMedicationDTO;
	}
	
	
}
