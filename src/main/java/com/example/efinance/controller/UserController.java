package com.example.efinance.controller;

import com.example.efinance.model.*;
import com.example.efinance.repository.UserRepo;
import com.example.efinance.service.PLoanServ;
import com.example.efinance.service.UserServImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserServImpl userServ;
    @Autowired
    private PLoanServ pLoanServ;

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

        userRepo.save(user);

        return "register_success";
    }
    @GetMapping("/account_view")
    public String listUsers(Model model) {
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        User user = userServ.accessByEmail(email);
        Long userId = user.getUid();
        List<AutoLoan> aLoanList = aLoanServ.accessByUser(userId);
        List<BusinessLoan> bLoanList = bLoanServ.accessByUser(userId);
        List<PersonalLoan> pLoanList = pLoanServ.accessByUser(userId);
        List<StudentLoan> sLoanList = sLoanServ.accessByUser(userId);


        model.addAttribute("aLoanList", aLoanList);
        model.addAttribute("bLoanList", bLoanList);
        model.addAttribute("pLoanList", pLoanList);
        model.addAttribute("sLoanList", sLoanList);

        return "account_view";
    }

}
