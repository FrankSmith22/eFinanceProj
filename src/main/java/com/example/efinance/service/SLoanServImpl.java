package com.example.efinance.service;

import com.example.efinance.model.StudentLoan;
import com.example.efinance.repository.SLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLoanServImpl implements SLoanServ {

    @Autowired
    private SLoanRepo sLoanRepo;

    @Override
    public void saveLoan(StudentLoan studentLoan) { this.sLoanRepo.save(studentLoan); }
}
