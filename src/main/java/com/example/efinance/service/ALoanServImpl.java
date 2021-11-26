package com.example.efinance.service;

import com.example.efinance.model.AutoLoan;
import com.example.efinance.repository.ALoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ALoanServImpl implements ALoanServ {

    @Autowired
    private ALoanRepo aLoanRepo;

    @Override
    public void saveLoan(AutoLoan autoLoan) { this.aLoanRepo.save(autoLoan); }
}
