package com.example.banking.service;

import com.example.banking.client.OrchestratorRestClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorService {
    private OrchestratorRestClient orchestratorRestClient;

    public OrchestratorService(OrchestratorRestClient orchestratorRestClient) {
        this.orchestratorRestClient = orchestratorRestClient;
    }

    public String generateMessage(long id) {


        String autoLoan = orchestratorRestClient.getAutoLoan(id);
        String deposit = orchestratorRestClient.getDeposit(id);
        String creditCard = orchestratorRestClient.getCreditCard(id);
        StringBuilder accountSummary = new StringBuilder();
        accountSummary.append("account summary ");
        accountSummary.append("deposit ");
        accountSummary.append(deposit);
        accountSummary.append("credit card ");
        accountSummary.append(creditCard);
        accountSummary.append("auto loan ");
        accountSummary.append(autoLoan);

        return accountSummary.toString();
    }
}
