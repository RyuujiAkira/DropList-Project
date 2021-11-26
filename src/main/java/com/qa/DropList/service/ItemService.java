package com.qa.DropList.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.DropList.domain.Item;
import com.qa.DropList.exceptions.ItemNotFoundException;
import com.qa.DropList.repo.ItemRepo;

@Service
public class ItemService {

	private ItemRepo repo;
	
	public ItemService(ItemRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public Item create(Item item) {
		return this.repo.saveAndFlush(item);
	}
	
	// Read All
	public List<Item> getAll() {
		return this.repo.findAll();
	}
	
	// Read By Id
	public Item getById(Long id) {
		return this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	// Custom Query - Find by item name
	public Item getByItemName(String item_name) {
		return this.repo.findByItemName(item_name).get();
	}
	
	// Update
    public Item update(Long id, Item item) {
    	Item existing = this.repo.findById(id).get();
    	existing.setItemName(item.getItemName());
    	existing.setItemType(item.getItemType());
    	existing.setItemBrand(item.getItemBrand());
    	existing.setReleaseDate(item.getReleaseDate());
    	return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}