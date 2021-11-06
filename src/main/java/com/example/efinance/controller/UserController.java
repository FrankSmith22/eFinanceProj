package com.example.efinance.controller;

import com.example.efinance.model.*;
import com.example.efinance.repository.UserRepository;
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

    @PostMapping("/loanApplication")
    public String showFields(Model model, Loan loan, AutoLoan autoLoan, BusinessLoan businessLoan, StudentLoan studentLoan){
        System.out.println("post method called");

        // Probably best to use a switch case to figure out which html page should be shown
        // the currently selected option in the dropdown is probably in the model parameter (using getAttribute)
        // Will need to modify loan_select.html then to add the selected value to the model upon submission


        return "loan_select";
    }

}
