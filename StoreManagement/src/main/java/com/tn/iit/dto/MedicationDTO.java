package com.tn.iit.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;


public class MedicationDTO {
	@NotNull
	private Integer id; 
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	@DecimalMin("0.01")
	private float price;
	
	private String categoryName;
	@NotNull
	private Integer categoryId;
	
	public MedicationDTO() {
		super();
	}

	public MedicationDTO(@Size(min = 1, max = 100) String name, @DecimalMin("0.01") float price, String categoryName,
			Integer categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.categoryName = categoryName;
		this.categoryId = categoryId;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}