package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.repository.DepositRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {
    private DepositRepository dr;

    public DepositService(DepositRepository dr) {
        this.dr = dr;
    }

    @HystrixCommand(fallbackMethod = "unavailableMessage")
    public Deposit save(Deposit deposit) {
        return dr.save(deposit);
    }

    public List<Deposit> findAllById(Long id) {
        return dr.findByClientId(id);
    }

    public List<Deposit> findAll() {
        return dr.findAll();
    }

    public Optional<Deposit> findById(Long id) {
        return dr.findById(id);
    }

    public Deposit updateDepositAccount(Long id, Deposit updatedAccount) {
        Deposit deposit = Deposit.builder()
                .withId(id)
                .withClientId(updatedAccount.getClientId())
                .withName(updatedAccount.getName())
                .withAccountNumber(updatedAccount.getAccountNumber())
                .build();
        return deposit;

    }

    public void delete(Long id) {
        dr.deleteById(id);
    }

    public String unavailableMessage(){
        return "No accounts available to show currently";
    }
}
