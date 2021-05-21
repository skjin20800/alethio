package com.alethio.service.controller.dto.order;

import com.alethio.service.domain.order.Orders;
import com.alethio.service.domain.order.info.ContactInfo;
import com.alethio.service.domain.order.info.Items;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderReqDto {

	private ContactInfo contactInfo;
	private Items items;

	//요청 Entity변환 및 trim하기
	public Orders toEntity() {
		return Orders.builder()
				.contactInfo(contactInfo.toEntity())
				.items(items.toEntity())
				.build();
	}

}
