package com.example.efinance.controller;

import com.example.efinance.model.Message;
import com.example.efinance.repository.MessageRepo;
import com.example.efinance.service.MessageServ;
import com.example.efinance.service.UserServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessagingController {
    private static final Logger log = LoggerFactory.getLogger(MessagingController.class);

    @Autowired
    private MessageServ messageServ;
    @Autowired
    private UserServ userServ;
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/inbox")
    public String inbox(Model model){
        return "inbox";
    }

    @GetMapping("/new_message")
    public String newMessage(Model model){
        model.addAttribute("message", new Message());
        return "new_message";
    }

    @PostMapping("/new_message")
    public String newMessage(@ModelAttribute("message") Message message, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        message.setUser(userServ.accessByEmail(email));
        messageServ.saveMessage(message);
        return "inbox";
    }
}
