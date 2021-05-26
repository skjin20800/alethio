package com.alethio.service.domain.receiving;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivingRepository extends JpaRepository<Receiving, Long> {
	
	@Transactional
	Receiving findByItemName(String itemName);
	
}