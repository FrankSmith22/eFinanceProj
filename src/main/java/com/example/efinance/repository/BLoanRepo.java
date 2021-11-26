package com.example.efinance.repository;

import com.example.efinance.model.BusinessLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BLoanRepo extends JpaRepository<BusinessLoan,Long> {
    @Query("SELECT u FROM BusinessLoan u WHERE u.user.uid = ?1")
    List<BusinessLoan> findByUser(Long userID);
}
