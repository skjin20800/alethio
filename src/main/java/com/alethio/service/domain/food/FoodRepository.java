package com.alethio.service.domain.food;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alethio.service.domain.item.ItemType;

public interface FoodRepository extends JpaRepository<Food, Long> {
		
	Food findByTypeIdAndItemType(Long typeId, ItemType itemType);

	
}