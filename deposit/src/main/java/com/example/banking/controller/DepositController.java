package com.example.banking.controller;

import com.example.banking.model.Deposit;
import com.example.banking.service.DepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepositController {
    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("deposit/createDepositAccount")
    public Deposit createDeposit(@RequestBody Deposit deposit){
        return this.depositService.save(deposit);
    }

    // TODO fix
    // does not find all by client id
    @GetMapping("deposit/getDepositAccountsByClientId/{clientId}")
    public List<Deposit> getDepositAccountsById(@PathVariable long clientId){
        return this.depositService.findAllById(clientId);
    }

    @GetMapping("deposit/getAllDepositAccounts")
    public List<Deposit> getAllLoans(){
        return this.depositService.findAll();
    }

    @PutMapping("deposit/updateDepositAccount/{id}")
    public Deposit updateLoan(@RequestBody Deposit updatedAccount, @PathVariable Long id){
        if(this.depositService.findById(id).isPresent()){

            return this.depositService.updateDepositAccount(id,updatedAccount);
        }
        else return null;
    }

    @DeleteMapping("deposit/deleteDepositAccount/{id")
    public String deleteLoan(@PathVariable Long id){
        if(this.depositService.findById(id).isPresent()) {
            this.depositService.delete(id);
            return "Deposit Account Deleted";
        }
        else
            return "Record not deleted.";
    }

}
