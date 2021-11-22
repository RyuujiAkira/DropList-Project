package com.qa.DropList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.DropList.domain.Item;
import com.qa.DropList.repo.ItemRepo;

@Service
public class ItemService {
	
	private ItemRepo repo;
		
		ItemService(ItemRepo repo) {
			super();
			this.repo = repo;
		}
		
		public Item createItem(Item item) {
			return this.repo.save(item);
		}
		
		public List<Item> readAll(){
			return this.repo.findAll();
		}
		
		public Item updateItem(Long id, Item item) {
			Optional<Item> existingOptional = this.repo.findById(id);
	        Item existing = existingOptional.get();

	        existing.setItemName(item.getItemName());
	        existing.setItemType(item.getItemType());
	        existing.setItemBrand(item.getItemBrand());
	        existing.setReleaseDate(item.getReleaseDate());
	        
	        return this.repo.save(existing);
		}
		
		public boolean deleteItem(Long id) {
	        this.repo.deleteById(id);
	        boolean exists = this.repo.existsById(id);
	        return !exists;
		}
}
