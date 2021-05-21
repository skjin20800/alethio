package com.alethio.service.domain.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {
	

	
	@Query(value = "SELECT * FROM clothes WHERE Id = ?1 AND amount > 0 ", nativeQuery = true)
	Clothes findByTypeId(Long typeId);
}