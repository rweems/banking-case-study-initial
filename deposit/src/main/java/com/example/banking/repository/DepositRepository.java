package com.example.banking.repository;

import com.example.banking.model.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends CrudRepository<Deposit,Long> {
    List<Deposit> findAllById(Long id);
    List<Deposit> findAll();

    List<Deposit> findByClientId(Long id);
}
