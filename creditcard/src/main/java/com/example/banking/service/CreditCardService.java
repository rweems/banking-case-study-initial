package com.example.banking.service;

import com.example.banking.model.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private CreditCardRepository cr;

    public CreditCardService(CreditCardRepository cr) {
        this.cr = cr;
    }

    public CreditCard save(CreditCard creditCard) {
        return cr.save(creditCard);
    }

    public List<CreditCard> findAllById(Long id) {
        return cr.findAllById(id);
    }

    public List<CreditCard> findAll() {
        return cr.findAll();
    }

    public Optional<CreditCard> findById(Long id) {
        return cr.findById(id);
    }

    public CreditCard updateAutoLoan(Long id, CreditCard updatedCard) {
        CreditCard creditCard = CreditCard.builder()
                .withId(id)
                .withClientId(updatedCard.getClientId())
                .withName(updatedCard.getName())
                .withNumber(updatedCard.getNumber())
                .build();
        return creditCard;
    }

    public void delete(Long id) {
        cr.deleteById(id);
    }
}
