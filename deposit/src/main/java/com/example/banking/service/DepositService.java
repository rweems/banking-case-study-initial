package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {
    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }


    public Deposit save(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public List<Deposit> findAllById(Long id) {
        return depositRepository.findAllById(id);
    }

    public List<Deposit> findAll() {
        return depositRepository.findAll();
    }

    public Optional<Deposit> findById(Long id) {
        return depositRepository.findById(id);
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
        depositRepository.deleteById(id);
    }
}
