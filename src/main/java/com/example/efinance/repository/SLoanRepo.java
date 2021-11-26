package com.example.efinance.repository;

import com.example.efinance.model.StudentLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SLoanRepo extends JpaRepository<StudentLoan,Long> {

}
