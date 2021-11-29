/*

PLoanServ.java
Interface for defining functionality of PersonalLoan model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.PersonalLoan;

import java.util.List;

public interface PLoanServ {
    void saveLoan(PersonalLoan personalLoan);

    public List<PersonalLoan> accessByUser(Long userID);
}
