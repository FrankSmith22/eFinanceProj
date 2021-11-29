/*

BLoanServImpl.java
Functionality for servicing BusinessLoan repository
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.BusinessLoan;
import com.example.efinance.repository.BLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLoanServImpl implements BLoanServ {

    @Autowired
    private BLoanRepo bLoanRepo;


    @Override
    public void saveLoan(BusinessLoan businessLoan) {
        this.bLoanRepo.save(businessLoan);
    }

    public List<BusinessLoan> accessByUser(Long userID){
        return this.bLoanRepo.findByUser(userID);
    }
}

