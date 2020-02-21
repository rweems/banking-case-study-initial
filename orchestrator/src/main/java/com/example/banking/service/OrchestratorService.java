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

        accountSummary.append("{ \n\"account summary\": { ");
        accountSummary.append("\n ");

        accountSummary.append(" \"depositAccounts\" : ");
        accountSummary.append(deposit);
        accountSummary.append(",\n ");

        accountSummary.append(" \"creditAccounts\" :");
        accountSummary.append(creditCard);
        accountSummary.append(",\n ");

        accountSummary.append(" \"autoLoanAccounts\" :");
        accountSummary.append(autoLoan);
        accountSummary.append("\n} \n}");
        return accountSummary.toString();
    }
}
