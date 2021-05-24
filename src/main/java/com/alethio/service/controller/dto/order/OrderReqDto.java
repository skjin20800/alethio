package com.alethio.service.controller.dto.order;

import javax.validation.constraints.NotNull;

import com.alethio.service.domain.order.Orders;
import com.alethio.service.domain.order.info.ContactInfo;
import com.alethio.service.domain.order.info.Items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReqDto {
	
	//고객 정보 객체
	@NotNull(message = "고객 정보를 입력하세요")
	private ContactInfo contactInfo;
	
	// 주몬 내용 객체
	@NotNull(message = "주문 정보를 입력하세요")
	private Items items;

	//Request Entity변환 및 trim하기
	public Orders toEntity() {
		return Orders.builder()
				.contactInfo(contactInfo.toEntity())
				.items(items.toEntity())
				.build();
	}

}
