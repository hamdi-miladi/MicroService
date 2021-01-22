package com.tn.iit.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class MedicationCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 1, max = 100)
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private Collection<Medication> medications;
	public MedicationCategory() {
		super();
	}
	public MedicationCategory(@Size(min = 1, max = 100) String name, Collection<Medication> medications) {
		super();
		this.name = name;
		this.medications = medications;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Medication> getMedications() {
		return medications;
	}
	public void setMedications(Collection<Medication> medications) {
		this.medications = medications;
	}
	
}
