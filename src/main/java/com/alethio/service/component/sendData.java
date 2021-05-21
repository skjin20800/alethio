package com.alethio.service.component;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;

import com.alethio.service.domain.receiving.Receiving;

@Component
public class sendData {
	
    private static RestTemplate restTemplate;

    public static ResponseEntity<Receiving> sendEngine(Receiving receiving) {
        int SubNum = 123;
        int Pnum = 1;
        Object Pcode = "코드";
        Receiving reqReceiving = receiving;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<Receiving> entity = new HttpEntity<>(reqReceiving, headers);

        String url = "http://localhost:8080/send";
        
        return restTemplate.exchange(url, HttpMethod.POST, entity, Receiving.class);
    }
    
//    public void asyncRestTemplateTest() throws InterruptedException, ExecutionException {
//        ListenableFuture<ResponseEntity<Map>> entity = asyncRestTemplate.getForEntity("https://httpbin.org/get", Map.class);
//        entity.addCallback(result -> {
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
//        }, ex -> System.out.println(ex.getStackTrace()));
//
//        System.out.println("asyncRestTemplateTest");
//        TimeUnit.SECONDS.sleep(8);
//    }
}


