package com.alethio.service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.alethio.service.controller.dto.order.OrderReqDto;
import com.alethio.service.domain.order.Orders;
import com.alethio.service.domain.order.info.ContactInfo;
import com.alethio.service.domain.order.info.Items;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FrontControllerIntegreTest {

	@Autowired
	private MockMvc mockMvc;
	
	//BDDMockito 패턴
	@Test
	public void order_통합테스트() throws Exception {

		// given(테스트를 하기 위한 준비)
		//Json 테스트 값
		ContactInfo contactInfo = new ContactInfo("test@test.com","   구매자   ","01099999999    ");
		Items item = new Items(1L,"food");
		Orders order = new Orders(null,contactInfo,item,null,null);
		OrderReqDto orderReqDto = new OrderReqDto(contactInfo, item);
		order = orderReqDto.toEntity();
		
		//테스트 데이터 Json변경
		String content = new ObjectMapper().writeValueAsString(order);

		//when(테스트 실행) //ResultAction -> 응답을 받을수있음
		@SuppressWarnings("deprecation")
		ResultActions resultAction = mockMvc.perform(post("/order") //get,put,post등
				.contentType(MediaType.APPLICATION_JSON_UTF8)//던지는타입,contentType("applicaton/json")
				.content(content)//실제던질데이터
				.accept(MediaType.APPLICATION_JSON_UTF8));//응답받을 데이터
		
		//then (검증)
		resultAction
		.andExpect(jsonPath("$.msg").value("주문 완료"))//jsonPath - json을 리턴한다.//
		.andDo(MockMvcResultHandlers.print()); //결과를 콘솔에 보여준다
		
	}

}
