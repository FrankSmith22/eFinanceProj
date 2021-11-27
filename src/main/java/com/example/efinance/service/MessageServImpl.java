package com.example.efinance.service;

import com.example.efinance.model.Message;
import com.example.efinance.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServImpl implements MessageServ{

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public void saveMessage(Message message) {
        this.messageRepo.save(message);
    }

    @Override
    public List<Message> accessByUser(Long userID) {
        return this.messageRepo.findByUser(userID);
    }
}
