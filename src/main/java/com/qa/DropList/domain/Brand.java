package com.qa.DropList.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandID;
	
	@Column(nullable = false)
	private String brandName;
	
	@Column(nullable = false)
	private String brandType;

	@OneToMany
	private Item item;

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

	public long getBrandID() {
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



	@Override
	public int hashCode() {
		return Objects.hash(brandType, brandID, brandName);
	}
}

