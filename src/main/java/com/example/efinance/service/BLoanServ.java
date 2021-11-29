/*

BLoanServ.java
Interface for defining functionality of BusinessLoan model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.BusinessLoan;

import java.util.List;

public interface BLoanServ {
    void saveLoan(BusinessLoan businessLoan);

    public List<BusinessLoan> accessByUser(Long userID);
}
