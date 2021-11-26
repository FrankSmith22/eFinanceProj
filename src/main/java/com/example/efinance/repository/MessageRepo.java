package com.example.efinance.repository;

import com.example.efinance.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Messages,Long> {

}
