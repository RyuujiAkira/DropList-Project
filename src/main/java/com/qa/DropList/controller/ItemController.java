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

import com.qa.DropList.domain.Item;
import com.qa.DropList.service.ItemService;

//200 - OK, 201 - Created, 202 - Accepted, 204 - No Content
//400 - Bad Request, 404 - Not Found, 500 - Internal Server Error

@RestController
@RequestMapping("/item") // http://localhost:8080/user/...
public class ItemController {

	private ItemService service;
	
	// Constructor Injection
	public ItemController(ItemService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Item> create(@RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.create(item), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<List<Item>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<Item> getOne(@PathVariable Long id) {
		return new ResponseEntity<Item>(this.service.getById(id), HttpStatus.OK);
	}
	
	// Custom Query - Get by item name
	@GetMapping("/getByItemName/{item_name}")
	public ResponseEntity<Item> getByItemName(@PathVariable String item_name) {
		return new ResponseEntity<Item>(this.service.getByItemName(item_name), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.update(id, item), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<Item>(HttpStatus.NO_CONTENT) 
				: new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}