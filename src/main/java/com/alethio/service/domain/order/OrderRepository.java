package com.alethio.service.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alethio.service.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
	
	
}