package com.alethio.service.domain.food;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<Food, Long> {
		
	@Transactional
	@Query(value = "SELECT * FROM food WHERE id = ?1 ", nativeQuery = true)
	Food findByTypeId(Long typeId);
	
	
	
	
}