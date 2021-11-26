package com.example.efinance.controller;

import com.example.efinance.repository.MessageSystemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessagingController {
    private static final Logger log = LoggerFactory.getLogger(MessagingController.class);

    @Autowired
    private MessageSystemRepository messageSystemRepository;




}
