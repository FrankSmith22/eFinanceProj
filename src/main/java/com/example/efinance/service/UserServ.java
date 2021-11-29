/*

UserServ.java
Interface for defining functionality of User model service class
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.service;

import com.example.efinance.model.User;

public interface UserServ {
    public User accessByEmail(String email);
}
