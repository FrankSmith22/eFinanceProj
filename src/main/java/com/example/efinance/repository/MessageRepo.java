/*

MessageRepo.java
Handles repository for Messaging System
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.repository;

import com.example.efinance.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message,Long> {
    @Query("SELECT u FROM Message u WHERE u.user.uid = ?1")
    List<Message> findByUser(Long userID);
}
