/*

MessagingController.java
Handles communication between the view and model for all the Messaging related routes
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.controller;

import com.example.efinance.model.Message;
import com.example.efinance.model.User;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

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
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        List<Message> messageList = messageServ.retrieveIncoming(email);
        model.addAttribute("messageList", messageList);
        //The following three lines of code are so that the message content view has something to display instead of erroring out
        Message message = new Message();
        message.setMessageContent("Please select a message from the feed to view it's content");
        model.addAttribute("message", message);
        return "inbox";
    }

    @GetMapping("/view_message/{messageId}")
    public String viewMessage(@PathVariable("messageId") Long messageId, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        List<Message> messageList = messageServ.retrieveIncoming(email);
        //Get specific email content
        Message message = null;
        for(Message mssg : messageList){
            if(mssg.getMessageId() == messageId){
                message = mssg;
            }
        }
        //Pass it to model
        model.addAttribute("messageList", messageList);
        model.addAttribute("message", message);
        //return inbox
        return "/inbox";
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
        return "redirect:/inbox";
    }
}
