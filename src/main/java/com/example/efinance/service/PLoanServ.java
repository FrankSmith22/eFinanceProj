package com.example.efinance.service;

import com.example.efinance.model.PersonalLoan;

import java.util.List;

public interface PLoanServ {
    void saveLoan(PersonalLoan personalLoan);

    public List<PersonalLoan> accessByUser(Long userID);
}
