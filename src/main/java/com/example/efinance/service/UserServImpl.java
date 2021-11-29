/*

UserServImpl.java
Functionality for servicing User repository
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.User;
import com.example.efinance.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserServ {
    @Autowired
    private UserRepo userRepository;

    public User accessByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
