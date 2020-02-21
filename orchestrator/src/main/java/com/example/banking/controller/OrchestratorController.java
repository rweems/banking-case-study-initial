package com.example.banking.controller;

import com.example.banking.service.OrchestratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestratorController {

    OrchestratorService orchestratorService;

    public OrchestratorController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @GetMapping(value = "/getAccountSummaryByClientId/{clientId}", produces = "application/json")
    public String getAccountSummary(@PathVariable long clientId){
        return orchestratorService.generateMessage(clientId);
    }
}
