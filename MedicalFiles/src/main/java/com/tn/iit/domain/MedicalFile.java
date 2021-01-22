package com.tn.iit.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.ToString;
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class MedicalFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Size(min = 1, max = 100)
	@Column(name = "patient_name")
	private String patientName;
	@NotNull
	@Column(name = "arrival_date")
	private LocalDateTime arrivalDate;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "medicalFile" ,fetch=FetchType.LAZY)
	private List<PrescribedMedication> medications;
	public MedicalFile() {
		super();
	}
	public MedicalFile(Integer id, @Size(min = 1, max = 100) String patientName, LocalDateTime arrivalDate,
			List<PrescribedMedication> medications) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.arrivalDate = arrivalDate;
		this.medications = medications;
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
	public List<PrescribedMedication> getMedications() {
		return medications;
	}
	public void setMedications(List<PrescribedMedication> medications) {
		this.medications = medications;
	}
}
