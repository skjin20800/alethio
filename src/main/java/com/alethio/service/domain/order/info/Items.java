package com.alethio.service.domain.order.info;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Items {
	
	@Column(insertable = false, updatable = false)
	private Long id;
	private String itemType;
	
	public Items toEntity() {
		this.itemType = itemType.trim();
		
		return this;
	}
	
}