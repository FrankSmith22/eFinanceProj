package com.example.efinance.service;

import com.example.efinance.model.PersonalLoan;
import com.example.efinance.repository.PLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PLoanServImpl implements PLoanServ {

    @Autowired
    private PLoanRepo pLoanRepo;

    @Override
    public void saveLoan(PersonalLoan personalLoan) {
        this.pLoanRepo.save(personalLoan);
    }

    public List<PersonalLoan> accessByUser(Long userID){
        return this.pLoanRepo.findByUser(userID);
    }
}
