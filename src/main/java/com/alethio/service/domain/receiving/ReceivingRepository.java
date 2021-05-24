package com.alethio.service.domain.receiving;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivingRepository extends JpaRepository<Receiving, Long> {
	
	Receiving findByItemName(String itemName);
	
}