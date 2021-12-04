/*

BLoanRepo.java
Handles repository for Business Loan
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.repository;

import com.example.efinance.model.BusinessLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BLoanRepo extends JpaRepository<BusinessLoan,Long> {
    @Query("SELECT u FROM BusinessLoan u WHERE u.user.uid = ?1")
    List<BusinessLoan> findByUser(Long userID);

    @Transactional
    @Modifying
    @Query("UPDATE BusinessLoan u SET u.loanAmount=u.loanAmount-?2 WHERE u.loanid=?1")
    public int processPayment(Long id, Long amount);
}
