package com.alethio.service.domain.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alethio.service.domain.item.ItemType;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {
	
	
	Clothes findByTypeIdAndItemType(Long typeId, ItemType itemType);
}