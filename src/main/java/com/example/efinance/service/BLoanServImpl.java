package com.example.efinance.service;

import com.example.efinance.model.BusinessLoan;
import com.example.efinance.repository.BLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLoanServImpl implements BLoanServ {

    @Autowired
    private BLoanRepo bLoanRepo;


    @Override
    public void saveLoan(BusinessLoan businessLoan) {
        this.bLoanRepo.save(businessLoan);
    }
}

