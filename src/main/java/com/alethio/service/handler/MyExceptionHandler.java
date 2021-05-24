package com.alethio.service.handler;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.alethio.service.controller.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@ControllerAdvice
public class MyExceptionHandler {
	// 모든 프로젝트에서 에러발생시 에러내용을 가져온다
	// 에러내용을 exceptionList에 저장한다

	private final ExceptionList exceptionList;
	
	@Transactional
	@ExceptionHandler(value = Exception.class)
	public CMRespDto<?> AllException(Exception e) {
		exceptionList.addExceptionList(e.getMessage());
		return new CMRespDto<>(-1, "오류 발생"+e.getMessage());
	}	
}