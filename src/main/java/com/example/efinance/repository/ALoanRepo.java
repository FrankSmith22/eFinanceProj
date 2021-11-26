package com.example.efinance.repository;

import com.example.efinance.model.AutoLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ALoanRepo extends JpaRepository<AutoLoan,Long> {

}
