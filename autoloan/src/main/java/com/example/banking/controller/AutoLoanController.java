package com.example.banking.controller;

import com.example.banking.model.AutoLoan;
import com.example.banking.service.AutoLoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoLoanController {

    private AutoLoanService autoLoanService;

    public AutoLoanController(AutoLoanService autoLoanService) {
        this.autoLoanService = autoLoanService;
    }

    @PostMapping("autoloan/createLoan")
    public AutoLoan creatLoan(@RequestBody AutoLoan autoLoan){
        return this.autoLoanService.save(autoLoan);
    }

    // TODO fix
    // does not find all by client id
    @GetMapping("autoloan/getLoansByClientId/{clientId}")
    public List<AutoLoan> getLoansById(@PathVariable Long clientId){
        return this.autoLoanService.findAllById(clientId);
    }

    @GetMapping("autoloan/getAllLoans")
    public List<AutoLoan> getAllLoans(){
        return this.autoLoanService.findAll();
    }

    @PutMapping("autoloan/updateLoan/{id}")
    public AutoLoan updateLoan(@RequestBody AutoLoan updatedLoan, @PathVariable Long id){
        if(this.autoLoanService.findById(id).isPresent()){

            return this.autoLoanService.updateAutoLoan(id,updatedLoan);
        }
        else return null;
    }

    @DeleteMapping("/autoloan/deleteLoan/{id}")
    public String deleteLoan(@PathVariable Long id){
        if(this.autoLoanService.findById(id).isPresent()) {
            this.autoLoanService.delete(id);
            return "Auto Loan Deleted";
        }
        else
            return "Record not deleted.";
    }

}
