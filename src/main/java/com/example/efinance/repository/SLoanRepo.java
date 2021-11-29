/*

SLoanRepo.java
Handles repository for StudentLoan
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.repository;

import com.example.efinance.model.StudentLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SLoanRepo extends JpaRepository<StudentLoan,Long> {
    @Query("SELECT u FROM StudentLoan u WHERE u.user.uid = ?1")
    List<StudentLoan> findByUser(Long userID);
}
