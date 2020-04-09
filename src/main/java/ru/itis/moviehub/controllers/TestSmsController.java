package ru.itis.moviehub.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestSmsController {

    @GetMapping("/sms")
    public String getUsersPage() {
        return "sms";
    }

    @RequestMapping(path = "/sms/send", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public void sendSms(@RequestParam("text") String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("diana.fedotova.2000@mail.ru", "BteGOsg8EB7VwgPJScAuboq0C3mM");
        String resourceUrl =
                "https://@gate.smsaero.ru/v2/sms/send?number=79869202913&text=" + text + "&sign=SMS Aero&channel=DIRECT";
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }
}
