package com.example.efinance.repository;

import com.example.efinance.model.BusinessLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLoanRepository extends JpaRepository<BusinessLoan,Long> {

}
