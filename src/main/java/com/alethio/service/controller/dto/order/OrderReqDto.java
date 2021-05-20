package com.alethio.service.controller.dto.order;

import com.alethio.service.domain.item.ItemType;
import com.alethio.service.domain.order.Order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderReqDto {

	private String username;
	private String email;
	private String mobile;
	
	private ItemType itemType;
	private Long typeId;	
	
	public Order toEntity() {

		return Order.builder()
				.username(username)
				.email(email)
				.mobile(mobile)
				.itemType(itemType)
				.typeId(typeId)
				.build();			
	}
	
}
