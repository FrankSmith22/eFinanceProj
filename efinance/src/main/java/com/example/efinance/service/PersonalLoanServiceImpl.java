package com.example.efinance.service;

import com.example.efinance.model.Loan;
import com.example.efinance.repository.PersonalLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalLoanServiceImpl implements PersonalLoanService{

    @Autowired
    private PersonalLoanRepository personalLoanRepository;

    @Override
    public void saveLoan(Loan loan) {
        this.personalLoanRepository.save(loan);
    }
}
