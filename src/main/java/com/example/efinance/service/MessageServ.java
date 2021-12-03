/*

MessageServ.java
Interface for defining functionality of Message model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.Message;

import java.util.List;

public interface MessageServ {
    public void saveMessage(Message message);

    public List<Message> accessByUser(Long userID);

    public List<Message> retrieveIncoming(String userEmail);
}
