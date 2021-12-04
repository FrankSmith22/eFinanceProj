/*

ALoanServ.java
Interface for defining functionality of AutoLoan model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.AutoLoan;

import java.util.List;

public interface ALoanServ {
    void saveLoan(AutoLoan autoLoan);

    public List<AutoLoan> accessByUser(Long userID);

    public void processPayment(Long id, Long amount);
}
