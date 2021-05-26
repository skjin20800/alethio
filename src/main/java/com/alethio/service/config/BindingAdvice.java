package com.alethio.service.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.alethio.service.controller.dto.CMRespDto;
import com.alethio.service.handler.ExceptionList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Aspect //공통기능 사용 어노테이션
public class BindingAdvice {

	private final ExceptionList exceptionList;

	@Around("execution(* com.alethio.service.controller..*Controller.*(..))") // controller패키지안의 모든 컨트롤러를 검사한다.
	public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //ProceedingJoinPoint는 공통기능이다

		Object[] args = proceedingJoinPoint.getArgs(); //요청받은 함수들을 args저장
		for (Object arg : args) { //함수크기만큼 반복문 실행
			if(arg instanceof BindingResult) {//arg중 BindingResult가 있을때만 동작
				BindingResult bindingResult = (BindingResult) arg; //BindingResult가 있다면 bindingResult변수에 저장
				if(bindingResult.hasErrors()) { //bindingResult에 에러가 발생한 부분을 찾아 에러코드와 함께 응답					
					Map<String, String> errorMap = new HashMap<>();
					for(FieldError error : bindingResult.getFieldErrors()) {// 에러가 발생한 필드 찾기
						// 에러코드를 exceptionList에 저장 -> 이후 배치시간이되면 DB에 자동저장
						exceptionList.addExceptionList(error.getDefaultMessage());
						// 에러메세지 출력
						errorMap.put(error.getField(), error.getDefaultMessage());
					}					
					return new CMRespDto<>(errorMap.toString().replaceAll("=", " error : "),null);
				}
			}
		}
		return proceedingJoinPoint.proceed();
	}
}