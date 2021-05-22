package com.alethio.service.service;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.alethio.service.domain.clothes.Clothes;
import com.alethio.service.domain.clothes.ClothesRepository;
import com.alethio.service.domain.food.Food;
import com.alethio.service.domain.food.FoodRepository;
import com.alethio.service.domain.order.OrderRepository;
import com.alethio.service.domain.order.Orders;
import com.alethio.service.domain.receiving.Receiving;
import com.alethio.service.domain.receiving.ReceivingRepository;
import com.alethio.service.util.secret.SecretReceiving;

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

//		IF문 : order의 ItemType 검사
		if (order.getItems().getItemType().equals("food")) {

//			요청 ID로 아이템 select
			Food food = foodRepository.findById(order.getItems().getId()).orElseThrow(() -> {
				// 아이템이 없다면 에러 반환
				return new IllegalArgumentException("아이템이 없습니다.");
			});
//			재고가 없을시 실행
			if (food.getAmount() <= 0) {
				return "재고가 없습니다.";
			}
//			아이템 수량 -1 [update]
			food.setAmount(food.getAmount() - 1);

//			아이템 수량이 10개이면 입고요청
			if (food.getAmount() == 10) {
				입고요청(food.getItemName(), order.getItems().getItemType(), 100L,
						SecretReceiving.ItemNameToAmadon(food.getItemName()));
			}

		} else if (order.getItems().getItemType().equals("clothes")) {
//			요청 ID로 아이템 select
			Clothes clothes = clothesRepository.findById(order.getItems().getId()).orElseThrow(() -> {
				// 아이템이 없다면 에러 반환
				return new IllegalArgumentException("아이템이 없습니다.");
			});
			
//			재고가 없을시 실행
			if (clothes.getAmount() <= 0) {
				return "재고가 없습니다.";
			}
			
//			아이템 수량 -1 [update]
			clothes.setAmount(clothes.getAmount() - 1);
				
//			아이템 수량이 10개이면 입고요청
			clothes.setAmount(clothes.getAmount() - 1);
			if (clothes.getAmount() == 10) {
				입고요청(clothes.getItemName(), order.getItems().getItemType(), 100L,
						SecretReceiving.ItemNameToCoumang(clothes.getItemName()));
			}
		} else {
			return "아이템이 없습니다.";
		}
		// IF문 종료

//		주문 insert		
		orderRepository.save(order);
		return "주문 완료";
	}

	@Transactional
	public void 입고요청(String itemName, String itemType, Long ReqReceiving, String SecretName) {
		Receiving receiving = new Receiving();
		receiving.setItemName(itemName);
		receiving.setItemType(itemType);
		receiving.setReqReceiving(100L);
		receiving.setSecretName(SecretName);
		receivingRepository.save(receiving);

	}

}
