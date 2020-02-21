package com.example.banking.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrchestratorRestClient {

    private RestTemplate restTemplate;
    StringBuilder stringBuilder;
    public OrchestratorRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAutoLoan(long id){
        stringBuilder = new StringBuilder();
        String uri = "http://localhost:9091/autoloan/getLoansByClientId/";
        stringBuilder.append(uri);
        stringBuilder.append(id);
        final String url = stringBuilder.toString();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String getDeposit(long id){
        stringBuilder = new StringBuilder();

        String uri = "http://localhost:9092/creditcard/getCreditCardsByClientId/";
        stringBuilder.append(uri);
        stringBuilder.append(id);
        final String url = stringBuilder.toString();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String getCreditCard(long id){
        stringBuilder = new StringBuilder();
        String uri = "http://localhost:9093/deposit/getDepositAccountsByClientId/";
        stringBuilder.append(uri);
        stringBuilder.append(id);
        final String url = stringBuilder.toString();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
