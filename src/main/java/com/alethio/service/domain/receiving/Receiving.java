package com.alethio.service.domain.receiving;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Receiving {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //시퀀스, auto_increment
	
	// 타입 ex) 옷, 음식
	@Column(nullable = false, length = 100)
	private String itemType;
	
	// 상품명 ex)떡볶이
	@Column(nullable = false, length = 100)
	private String itemName;
	
	// 암호화 이름 ex)123떡볶이
	@Column(nullable = false, length = 100)
	private String secretName;
	
	// 요청 갯수 ex ) 100개 요청
	@Column(nullable = false, length = 100)
	private Long receiving;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
	
}