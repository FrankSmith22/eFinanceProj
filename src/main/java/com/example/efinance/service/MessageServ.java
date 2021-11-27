package com.example.efinance.service;

import com.example.efinance.model.Message;

import java.util.List;

public interface MessageServ {
    public void saveMessage(Message message);

    public List<Message> accessByUser(Long userID);
}
