package com.qa.DropList.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemID;
	
	@Column(nullable = false)
	private String itemName;
	
	@Column(nullable = false)
	private String itemType;
	
	@Column(nullable = false)
	private String itemBrand;
	
	@Column(nullable = false)
	private Date releaseDate;

	@ManyToOne
	private Brand brand;

	public Item() {
		super();
	}

	public Item(long itemID, String itemName, String itemType, String itemBrand, Date releaseDate) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemBrand = itemBrand;
		this.releaseDate = releaseDate;
	}

	public Item(String itemName, String itemType, String itemBrand, Date releaseDate) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemBrand = itemBrand;
		this.releaseDate = releaseDate;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(releaseDate, itemBrand, itemID, itemType);
	}
}
