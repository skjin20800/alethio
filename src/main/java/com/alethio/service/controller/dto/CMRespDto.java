package com.alethio.service.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {
	private String msg; // 응답 메세지
	private int statusCode; // 상태코드 : 200 성공
	private T data; // 응답 데이터
	
	public CMRespDto(int statusCode,  String msg, T data) {
		this.statusCode = statusCode;
		this.data = data;
		this.msg = msg;
	}
	
	public CMRespDto(int statusCode, T data) {
		this.statusCode = statusCode;
		this.data = data;
	}
	
	public CMRespDto(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
	
}