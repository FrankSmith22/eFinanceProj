/*

SLoanServ.java
Interface for defining functionality of StudentLoan model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.StudentLoan;

import java.util.List;

public interface SLoanServ {
    void saveLoan(StudentLoan studentLoan);

    public List<StudentLoan> accessByUser(Long userID);
}
