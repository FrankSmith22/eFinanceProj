package com.example.efinance.controller;

import com.example.efinance.model.*;
import com.example.efinance.repository.UserRepository;
import com.example.efinance.service.AutoLoanService;
import com.example.efinance.service.BusinessLoanService;
import com.example.efinance.service.PersonalLoanService;
import com.example.efinance.service.StudentLoanService;
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
    @Autowired
    private BusinessLoanService businessLoanService;
    @Autowired
    private StudentLoanService studentLoanService;
    @Autowired
    private AutoLoanService autoLoanService;

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

    //Personal Loan

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

    //Auto Loan

    @GetMapping("/AutoLoan")
    public String showAutoLoan(Model model){
        model.addAttribute("autoLoan", new AutoLoan());
        return "auto_loan_application";
    }

    @PostMapping("/AutoLoan")
    public String showAutoLoan(@ModelAttribute("autoLoan") AutoLoan autoLoan, Model model){
        autoLoanService.saveLoan(autoLoan);
        return "thank_you";
    }

    //Business Loan

    @GetMapping("/BusinessLoan")
    public String showBusinessLoan(Model model){
        model.addAttribute("businessLoan", new BusinessLoan());
        return "business_loan_application";
    }

    @PostMapping("/BusinessLoan")
    public String showBusinessLoan(@ModelAttribute("businessLoan") BusinessLoan businessLoan, Model model){
        businessLoanService.saveLoan(businessLoan);
        return "thank_you";
    }

    //Student Loan

    @GetMapping("/StudentLoan")
    public String showStudentLoan(Model model){
        model.addAttribute("studentLoan", new StudentLoan());
        return "student_loan_application";
    }

    @PostMapping("/StudentLoan")
    public String showStudentLoan(@ModelAttribute("studentLoan") StudentLoan studentLoan, Model model){
        studentLoanService.saveLoan(studentLoan);
        return "thank_you";
    }

}
