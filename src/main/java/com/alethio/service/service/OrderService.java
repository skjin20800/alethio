package com.alethio.service.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alethio.service.domain.order.Order;
import com.alethio.service.repository.order.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	@Transactional
	public int 주문하기(Order order) {
		
		
//		1.if(주문 타입과 id로 select하여 테이블이 있는지 검색)
		
		orderRepository.findBytypeIdAnd
		
		orderRepository.save(order);				
		
		/*
		 * Board boardEntity = boardRepository.save(board); if(boardEntity == null) {
		 * return -1; }else { return 1; }
		 */
		return 1;
	}

	
}
