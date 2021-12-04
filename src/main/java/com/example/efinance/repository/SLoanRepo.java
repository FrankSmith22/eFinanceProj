/*

SLoanRepo.java
Handles repository for StudentLoan
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.repository;

import com.example.efinance.model.StudentLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SLoanRepo extends JpaRepository<StudentLoan,Long> {
    @Query("SELECT u FROM StudentLoan u WHERE u.user.uid = ?1")
    List<StudentLoan> findByUser(Long userID);

    @Transactional
    @Modifying
    @Query("UPDATE StudentLoan u SET u.loanAmount=u.loanAmount-?2 WHERE u.loanid=?1")
    public int processPayment(Long id, Long amount);
}
