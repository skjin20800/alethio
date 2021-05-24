package com.alethio.service.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alethio.service.controller.dto.CMRespDto;
import com.alethio.service.controller.dto.order.OrderReqDto;
import com.alethio.service.domain.order.Orders;
import com.alethio.service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FrontController {

	// 주문 서비스
	private final OrderService orderService;

	// 주문 메서드
	@PostMapping("/order")
	public CMRespDto<?> order(@Valid @RequestBody OrderReqDto orderReqDto, BindingResult bindingResult) {
		Orders order = orderReqDto.toEntity();
		return new CMRespDto<>(200, orderService.주문하기(order));

	}
}
