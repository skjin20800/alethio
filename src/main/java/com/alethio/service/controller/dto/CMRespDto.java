package com.alethio.service.controller.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CMRespDto<T> {
	private String msg; // 응답 메세지
	private T data; // 응답 데이터
		
	public CMRespDto(String msg, T data) {
		this.msg = msg;
		this.data = data;
	}
	

	
	
}