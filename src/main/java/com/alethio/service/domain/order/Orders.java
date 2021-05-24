package com.alethio.service.domain.order;

import java.sql.Timestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.alethio.service.domain.order.info.ContactInfo;
import com.alethio.service.domain.order.info.Items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orders {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 주문 고객 정보
	@Embedded
	 private ContactInfo contactInfo;
	
	// 주문 정보
	@Embedded
	 private Items items;	
	  
	 @CreationTimestamp
	 private Timestamp createDate;
	 
	 @UpdateTimestamp
	 private Timestamp updateDate;
	 
	
}