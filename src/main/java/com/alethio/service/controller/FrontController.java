package com.alethio.service.controller;

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

	private final OrderService orderService;

	@PostMapping("/order")
	public CMRespDto<?> order(@RequestBody OrderReqDto orderReqDto) {
		Orders order = orderReqDto.toEntity();
		return new CMRespDto<>(200, orderService.주문하기(order));

	}
}
