package com.qa.DropList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.qa.DropList.domain.Item;
import com.qa.DropList.service.ItemService;




@RestController
@RequestMapping("/item")
public class ItemController {
	
	private ItemService service;

	// Constructor Injection
	public ItemController(ItemService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Item> create(@RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.createItem(item), HttpStatus.CREATED);
	}

	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<List<Item>>(this.service.readAll(), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.updateItem(id, item), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> delete(@PathVariable Long id){
		return this.service.deleteItem(id) ? new ResponseEntity<Item>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
