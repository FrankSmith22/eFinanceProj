package com.example.efinance.service;

import com.example.efinance.model.AutoLoan;

import java.util.List;

public interface ALoanServ {
    void saveLoan(AutoLoan autoLoan);

    public List<AutoLoan> accessByUser(Long userID);
}
