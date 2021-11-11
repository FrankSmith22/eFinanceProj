package com.example.efinance.service;

import com.example.efinance.model.AutoLoan;
import com.example.efinance.repository.AutoLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoLoanServiceImpl implements AutoLoanService{

    @Autowired
    private AutoLoanRepository autoLoanRepository;

    @Override
    public void saveAutoLoan(AutoLoan autoLoan) { this.autoLoanRepository.save(autoLoan); }
}
