package com.example.efinance.service;

import com.example.efinance.model.User;

public interface UserServ {
    public User accessByEmail(String email);
}
