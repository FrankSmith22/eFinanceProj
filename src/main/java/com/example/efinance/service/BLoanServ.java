package com.example.efinance.service;

import com.example.efinance.model.BusinessLoan;

import java.util.List;

public interface BLoanServ {
    void saveLoan(BusinessLoan businessLoan);

    public List<BusinessLoan> accessByUser(Long userID);
}
