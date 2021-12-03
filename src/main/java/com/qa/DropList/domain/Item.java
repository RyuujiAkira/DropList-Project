package com.qa.DropList.domain;

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
	private Long itemID;
	
	@Column(nullable = false)
	private String itemName;
	
	@Column(nullable = false)
	private String itemType;
	
	@Column(nullable = false)
	private Long itemBrandID;
	
	@Column(nullable = false)
	private String releaseDate;

	@ManyToOne
	private Brand brand;

	public Item() {
		super();
	}

	public Item(Long itemID, String itemName, String itemType, Long itemBrandID, String releaseDate) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemBrandID = itemBrandID;
		this.releaseDate = releaseDate;
	}

	public Item(String itemName, String itemType, Long itemBrandID, String releaseDate) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemBrandID = itemBrandID;
		this.releaseDate = releaseDate;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
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

	public Long getItemBrandID() {
		return itemBrandID;
	}

	public void setItemBrandID(Long itemBrandID) {
		this.itemBrandID = itemBrandID;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(releaseDate, itemBrandID, itemID, itemType, brand);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(releaseDate, other.releaseDate) && Objects.equals(itemBrandID, other.itemBrandID)
				&& Objects.equals(itemID, other.itemID) && Objects.equals(itemType, other.itemType) 
				&& Objects.equals(brand, other.brand);
	}
}
