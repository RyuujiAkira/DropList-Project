package com.qa.DropList.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandID;
	
	@Column(name = "brandName", nullable = false)
	private String brandName;
	
	@Column(name = "brandType", nullable = false)
	private String brandType;

	@JsonIgnore
	@OneToMany(mappedBy="brand")
	private List <Item> items;

	public Brand() {
		super();
	}

	public Brand(Long brandID, String brandName, String brandType) {
		this.brandID = brandID;
		this.brandName = brandName;
		this.brandType = brandType;
	}

	public Brand(String brandName, String brandType) {
		this.brandName = brandName;
		this.brandType = brandType;
	}

	public Long getBrandID() {
		return brandID;
	}

	public void setBrandID(Long brandID) {
		this.brandID = brandID;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setAppointments(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, brandType, brandID, brandName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(items, other.items) && Objects.equals(brandName, other.brandName) && brandID == other.brandID 
				&& Objects.equals(brandType, other.brandType);
	}
}



