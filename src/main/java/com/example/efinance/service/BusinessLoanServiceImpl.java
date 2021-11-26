package com.example.efinance.service;

import com.example.efinance.model.BusinessLoan;
import com.example.efinance.repository.BusinessLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLoanServiceImpl implements BusinessLoanService{

    @Autowired
    private BusinessLoanRepository businessLoanRepository;


    @Override
    public void saveBusinessLoan(BusinessLoan businessLoan) {
        this.businessLoanRepository.save(businessLoan);
    }
}

