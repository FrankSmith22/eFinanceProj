package com.example.efinance.repository;

import com.example.efinance.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalLoanRepository extends JpaRepository<Loan,Long> {

}
