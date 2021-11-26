package com.example.efinance.service;

import com.example.efinance.model.StudentLoan;

import java.util.List;

public interface SLoanServ {
    void saveLoan(StudentLoan studentLoan);

    public List<StudentLoan> accessByUser(Long userID);
}
