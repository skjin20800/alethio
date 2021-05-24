package com.alethio.service.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class ExceptionList {	

	//에러들을 모아놓는 간단한 String List이다
	public List<String> exList = new ArrayList<>();
	
	// 에러를 담을수있는 함수를 제공한다.	
	public void addExceptionList(String str) {
		exList.add(str);
	}
}