package com.qa.DropList.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.DropList.domain.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{

	@Query(value = "SELECT * FROM item WHERE item_name = ?1", nativeQuery = true)
	Optional<Item> findByItemName(String item_name);
	
}