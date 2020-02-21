package com.example.banking.controller;

import com.example.banking.model.CreditCard;
import com.example.banking.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("creditcard/createCreditCard")
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard){
        return this.creditCardService.save(creditCard);
    }

    // TODO fix
    // does not find all by client id
    @GetMapping("creditcard/getCreditCardsByClientId/{clientId}")
    public List<CreditCard> getCardsById(@PathVariable Long clientId){
        return this.creditCardService.findAllById(clientId);
    }

    @GetMapping("creditcard/getAllCreditCards")
    public List<CreditCard> getAllCards(){
        return this.creditCardService.findAll();
    }

    @PutMapping("creditcard/updateCreditCard/{id}")
    public CreditCard updateCardById(@RequestBody CreditCard updatedLoan, @PathVariable Long id){
        if(this.creditCardService.findById(id).isPresent()){

            return this.creditCardService.updateAutoLoan(id,updatedLoan);
        }
        else return null;
    }

    @DeleteMapping("creditcard/deleteCreditCard/{id}")
    public String deleteCardById(@PathVariable Long id){
        if(this.creditCardService.findById(id).isPresent()) {
            this.creditCardService.delete(id);
            return "Credit Card Deleted";
        }
        else
            return "Record not deleted.";
    }

}
