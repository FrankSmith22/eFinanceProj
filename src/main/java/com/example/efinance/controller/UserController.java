package com.example.efinance.controller;

import com.example.efinance.model.*;
import com.example.efinance.repository.UserRepository;
import com.example.efinance.service.PersonalLoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonalLoanService personalLoanService;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }
    @GetMapping("/account_view")
    public String listUsers(Model model) {

        return "account_view";
    }

    @GetMapping("/loanApplication")
    public String showApplication(Model model){
        return "loan_select";
    }

    @GetMapping("/PersonalLoan")
    public String showPersonalLoan(Model model){
        model.addAttribute("personalLoan", new Loan());
        return "personal_loan_application";
    }

    @PostMapping("/PersonalLoan")
    public String showPersonalLoan(@ModelAttribute("personalLoan") Loan personalLoan, Model model){
        personalLoanService.saveLoan(personalLoan);
        return "thank_you";
    }

    @GetMapping("/AutoLoan")
    public String showAutoLoan(Model model){
        return "auto_loan_application";
    }

    @GetMapping("/BusinessLoan")
    public String showBusinessLoan(Model model){
        return "business_loan_application";
    }

    @GetMapping("/StudentLoan")
    public String showStudentLoan(Model model){
        return "student_loan_application";
    }

}
