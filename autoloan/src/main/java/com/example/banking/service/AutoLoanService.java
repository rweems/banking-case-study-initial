package com.example.banking.service;

import com.example.banking.model.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoLoanService {

    private AutoLoanRepository ar;

    public AutoLoanService(AutoLoanRepository ar) {
        this.ar = ar;
    }

    public AutoLoan save(AutoLoan autoLoan) {
        return ar.save(autoLoan);
    }

    public List<AutoLoan> findAllById(Long id) {
        return ar.findAllById(id);
    }



    public List<AutoLoan> findAll() {
        return ar.findAll();
    }

    public Optional<AutoLoan> findById(Long id) {
        return ar.findById(id);
    }

    public AutoLoan updateAutoLoan(Long id, AutoLoan updatedLoan) {

        AutoLoan autoLoan = AutoLoan.builder()
                .withId(id)
                .withClientId(updatedLoan.getClientId())
                .withName(updatedLoan.getName())
                .build();
        return autoLoan;
    }

    public void delete(Long id) {
        ar.deleteById(id);
    }
}
