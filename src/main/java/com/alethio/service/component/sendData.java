package com.alethio.service.component;

@Component
public class sendData {
    private static RestTemplate restTemplate;

    public static ResponseEntity<SubmitData> sendEngine() {
        int SubNum = 123;
        int Pnum = 1;
        Object Pcode = "코드";
        SubmitData requestDto = SubmitData.builder()
                .SubNum(SubNum)
                .Pnum(Pnum)
                .Pcode(Pcode)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<SubmitData> entity = new HttpEntity<>(requestDto, headers);

        String url = "http://localhost:8080/send";
        
        return restTemplate.exchange(url, HttpMethod.POST, entity, SubmitData.class);
    }
}