package com.alethio.service.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alethio.service.domain.clothes.Clothes;
import com.alethio.service.domain.clothes.ClothesRepository;
import com.alethio.service.domain.food.Food;
import com.alethio.service.domain.food.FoodRepository;
import com.alethio.service.domain.order.Order;
import com.alethio.service.domain.order.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	//주문 DB
	private final OrderRepository orderRepository;
	
	//음식 DB
	private final FoodRepository foodRepository;
	
	//옷 DB
	private final ClothesRepository clothesRepository;
	
	@Transactional
	public int 주문하기(Order order) {
		
//		1. order 값중 해당 아이템이 존재하는지 검사
//     [미추가] 재고조사해서 1이상인값만 조회		
		if(order.getItemType().equals("food")) {
			foodRepository.findByTypeIdAndItemType(order.getTypeId(), order.getItemType());
		}else if(order.getItemType().equals("clothes")){
			clothesRepository.findByTypeIdAndItemType(order.getTypeId(), order.getItemType());
		}else {
			System.out.println("아이템 없음' 에러를 반환");
			return -1;
		}
		
//		2. 주문 테이블 저장
		orderRepository.save(order);

//    3. 아이템 수정 (재고 -1) 
		if(order.getItemType().equals("food")) {
			Food food = foodRepository.findByTypeIdAndItemType(order.getTypeId(), order.getItemType());
		    food.setAmount(food.getAmount()-1);
		}else if(order.getItemType().equals("clothes")){
			Clothes clotes = clothesRepository.findByTypeIdAndItemType(order.getTypeId(), order.getItemType());
			clotes.setAmount(clotes.getAmount()-1);
		}else {
			System.out.println(" 재고 -1 실패");
			return -1;
		}
		
// 4. 입고요청 주고받기
		
		
		return 1;
	}

	
}
