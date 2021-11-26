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

import com.qa.DropList.domain.Brand;
import com.qa.DropList.service.BrandService;

//200 - OK, 201 - Created, 202 - Accepted, 204 - No Content
//400 - Bad Request, 404 - Not Found, 500 - Internal Server Error

@RestController
@RequestMapping("/brand") // http://localhost:8080/user/...
public class BrandController {

	private BrandService service;
	
	// Constructor Injection
	public BrandController(BrandService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Brand> create(@RequestBody Brand brand) {
		return new ResponseEntity<Brand>(this.service.create(brand), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Brand>> getAll() {
		return new ResponseEntity<List<Brand>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<Brand> getOne(@PathVariable Long id) {
		return new ResponseEntity<Brand>(this.service.getById(id), HttpStatus.OK);
	}
	
	// Custom Query - Get by brand name
	@GetMapping("/getByBrandName/{brand_name}")
	public ResponseEntity<Brand> getByBrandName(@PathVariable String brand_name) {
		return new ResponseEntity<Brand>(this.service.getByBrandName(brand_name), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand brand) {
		return new ResponseEntity<Brand>(this.service.update(id, brand), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Brand> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<Brand>(HttpStatus.NO_CONTENT) 
				: new ResponseEntity<Brand>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}