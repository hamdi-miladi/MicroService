package com.tn.iit.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Medication implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	@DecimalMin("0.01")
	private float price;
	@JoinColumn(name="category",referencedColumnName = "id")
	@ManyToOne
	private MedicationCategory category;
	public Medication() {
		super();
	}
	
	public Medication(Integer id) {
		super();
		this.id = id;
	}

	public Medication(@Size(min = 1, max = 100) String name, @DecimalMin("0.01") float price,
			MedicationCategory category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public MedicationCategory getCategory() {
		return category;
	}
	public void setCategory(MedicationCategory category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
