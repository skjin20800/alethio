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
	 
	private String contactName;	
	private String contactEmail;
	private String mobile;
	
	public ContactInfo toEntity() {
		
		this.contactName = contactName.trim();
		this.contactEmail = contactEmail.trim();
		this.mobile = mobile.trim();
		
		return this;
	}
	
	
	
}