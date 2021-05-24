package com.alethio.service.domain.clothes;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Clothes {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //
	
	// 상품명 ex)A 청바지
	@Column(nullable = false, length = 100, unique = true)
	private String itemName;
	
	// 현재 상품 수량 ex)57개
	@Column(nullable = false, length = 100)
	private Long amount;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
	
}
