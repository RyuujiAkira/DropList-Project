package com.qa.DropList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.DropList.domain.Brand;
import com.qa.DropList.repo.BrandRepo;

@Service
public class BrandService {
	private BrandRepo repo;
	
	BrandService(BrandRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Brand createBrand(Brand brand) {
		return this.repo.save(brand);
	}
	
	public List<Brand> readAll(){
		return this.repo.findAll();
	}
	
	public Brand updateBrand(Long id, Brand brand) {
		Optional<Brand> existingOptional = this.repo.findById(id);
        Brand existing = existingOptional.get();

        existing.setBrandName(brand.getBrandName());
        existing.setBrandType(brand.getBrandType());
        
        return this.repo.save(existing);
	}
	
	public boolean deleteBrand(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
	}
}
