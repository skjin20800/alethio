package com.alethio.service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alethio.service.domain.clothes.Clothes;
import com.alethio.service.domain.clothes.ClothesRepository;
import com.alethio.service.domain.food.Food;
import com.alethio.service.domain.food.FoodRepository;
import com.alethio.service.domain.order.OrderRepository;
import com.alethio.service.domain.order.Orders;
import com.alethio.service.domain.receiving.ReceivingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	// 주문 DB
	private final OrderRepository orderRepository;
	
	// 재고 DB
	private final ReceivingRepository receivingRepository;

	// 음식 DB
	private final FoodRepository foodRepository;
	
	// 옷 DB
	private final ClothesRepository clothesRepository;

	@Transactional
	public String 주문하기(Orders order) {
//		1. order 값중 해당 아이템이 존재하는지, 재고가 1개 이상인지 조회
//		2. 아이템 수정 (재고 -1)
//	    3. 주문 테이블 저장		
		if (order.getItems().getItemType().equals("food")) {
			Food food = foodRepository.findByTypeId(order.getItems().getId());
			
			if(food.getAmount() <= 0) {
				return "재고가 없습니다.";
			}
			
			food.setAmount(food.getAmount() - 1);
			
			if(food.getAmount()==98) {

//				재고요청
			}				
			
		} else if (order.getItems().getItemType().equals("clothes")) {
			Clothes clothes = clothesRepository.findByTypeId(order.getItems().getId());
			clothes.setAmount(clothes.getAmount() - 1);
		} else {
			return "아이템이 없습니다.";
		}
		
		orderRepository.save(order);

// 4. 입고요청 주고받기
		
		

		return "주문 완료";
	}

}
