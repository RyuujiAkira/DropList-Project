package com.qa.DropList.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.DropList.domain.Brand;

@Repository
public interface BrandRepo extends JpaRepository <Brand, Long>{
	
}
