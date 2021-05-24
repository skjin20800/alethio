package com.alethio.service.handler;


import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alethio.service.domain.exception.MyExceptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component // Ioc컨테이너 띄우기
public class MyBatch {
	
	private final ExceptionList exceptionList;
	private final MyExceptionRepository exceptionRepository;

	// excute함수는 배열안의 모든 에러를 DB에 저장후 배열을 초기화시킨다.
	@Scheduled(fixedDelay = 1000*60) // 1분마다 실행//Cron 정기적 실행
	public void excute() {
		List<String> exList = exceptionList.getExList();
		for (String exception : exList) {
			exceptionRepository.mException(exception);	
		}
		exList.clear();
	}
}