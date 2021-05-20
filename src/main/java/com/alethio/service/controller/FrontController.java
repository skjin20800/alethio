package com.alethio.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alethio.service.controller.dto.CMRespDto;
import com.alethio.service.controller.dto.order.OrderReqDto;
import com.alethio.service.domain.order.Order;
import com.alethio.service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FrontController {
	
	private final OrderService orderService;
	
	
	@PostMapping("/order")
	public CMRespDto<?> save(@RequestBody OrderReqDto orderReqDto ) {
		
		Order order = orderReqDto.toEntity();
		orderService.주문하기(order);
		
		/*
		 * Board board = boardPostReqDto.toEntity();
		 * board.setUser(principalDetails.getUser()); board.setType(type); int result =
		 * boardService.글쓰기(board);
		 */

		return new CMRespDto<>(0,null);
		}
	
}
