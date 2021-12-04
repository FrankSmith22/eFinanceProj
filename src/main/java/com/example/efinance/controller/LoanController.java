/*

LoanController.java
Handles communication between the view and model for all loan related routes
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.controller;

import com.example.efinance.model.*;
import com.example.efinance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoanController {

    @Autowired
    private PLoanServ pLoanServ;
    @Autowired
    private BLoanServ bLoanServ;
    @Autowired
    private SLoanServ sLoanServ;
    @Autowired
    private ALoanServ aLoanServ;
    @Autowired
    private UserServImpl userServ;

    @GetMapping("/loan_application")
    public String showApplication(Model model){
        return "loan_select";
    }

    //Personal Loan

    @GetMapping("/personal_loan")
    public String showPersonalLoan(Model model){
        model.addAttribute("personalLoan", new PersonalLoan());
        return "personal_loan_application";
    }

    @PostMapping("/personal_loan")
    public String showPersonalLoan(@ModelAttribute("personalLoan") PersonalLoan personalLoan, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        personalLoan.setUser(userServ.accessByEmail(email));
        pLoanServ.saveLoan(personalLoan);
        return "thank_you";
    }

    //Auto Loan

    @GetMapping("/auto_loan")
    public String showAutoLoan(Model model){
        model.addAttribute("autoLoan", new AutoLoan());
        return "auto_loan_application";
    }

    @PostMapping("/auto_loan")
    public String showAutoLoan(@ModelAttribute("autoLoan") AutoLoan autoLoan, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        autoLoan.setUser(userServ.accessByEmail(email));
        aLoanServ.saveLoan(autoLoan);
        return "thank_you";
    }

    //Business Loan

    @GetMapping("/business_loan")
    public String showBusinessLoan(Model model){
        model.addAttribute("businessLoan", new BusinessLoan());
        return "business_loan_application";
    }

    @PostMapping("/business_loan")
    public String showBusinessLoan(@ModelAttribute("businessLoan") BusinessLoan businessLoan, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        businessLoan.setUser(userServ.accessByEmail(email));
        bLoanServ.saveLoan(businessLoan);
        return "thank_you";
    }

    //Student Loan

    @GetMapping("/student_loan")
    public String showStudentLoan(Model model){
        model.addAttribute("studentLoan", new StudentLoan());
        return "student_loan_application";
    }

    @PostMapping("/student_loan")
    public String showStudentLoan(@ModelAttribute("studentLoan") StudentLoan studentLoan, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        studentLoan.setUser(userServ.accessByEmail(email));
        sLoanServ.saveLoan(studentLoan);
        return "thank_you";
    }

    @GetMapping("/make_payment/{type}/{id}/{balance}")
    public String makePayment(@PathVariable("type") String type, @PathVariable("id") long id, @PathVariable("balance") long balance, Model model){
        model.addAttribute("type", type);
        model.addAttribute("id", id);
        model.addAttribute("balance", balance);
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        //to-do Add current balance here to model to be displayed
        return "make_payment";
    }

    @PostMapping("/make_payment/{type}/{id}")
    public String makePayment(@PathVariable("type") String type, @PathVariable("id") Long id, @ModelAttribute("payment") Payment payment, Model model){
        Long amount = payment.getAmount();
        //Logic for subtracting amount from balance
        switch(type){
            case "auto":
                aLoanServ.processPayment(id, amount);
                break;
            case "business":
                bLoanServ.processPayment(id, amount);
                break;
            case "personal":
                pLoanServ.processPayment(id, amount);
                break;
            case "student":
                sLoanServ.processPayment(id, amount);
                break;
        }
        return "thank_you";
    }
}