package com.alethio.service.domain.order.info;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
	 
	// 고객 아이디
	private String contactName;
	
	// 고객 이메일
	private String contactEmail;
	
	// 고객 폰번호
	private String mobile;
	
	// 고객 정보 trim하는 메서드
	public ContactInfo toEntity() {
		
		this.contactName = contactName.trim();
		this.contactEmail = contactEmail.trim();
		this.mobile = mobile.trim();
		
		return this;
	}
	
	
	
}