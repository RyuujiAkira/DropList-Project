package com.qa.DropList.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.DropList.domain.Brand;
import com.qa.DropList.exceptions.BrandNotFoundException;
import com.qa.DropList.repo.BrandRepo;

@Service
public class BrandService {

	private BrandRepo repo;
	
	public BrandService(BrandRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public Brand create(Brand brand) {
		return this.repo.saveAndFlush(brand);
	}
	
	// Read All
	public List<Brand> getAll() {
		return this.repo.findAll();
	}
	
	// Read By Id
	public Brand getById(Long id) {
		return this.repo.findById(id).orElseThrow(BrandNotFoundException::new);
	}
	
	// Custom Query - Find by item name
	public Brand getByBrandName(String brand_name) {
		return this.repo.findByBrandName(brand_name).get();
	}
	
	// Update
    public Brand update(Long id, Brand brand) {
    	Brand existing = this.repo.findById(id).get();
    	existing.setBrandName(brand.getBrandName());
    	existing.setBrandType(brand.getBrandType());
    	return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}