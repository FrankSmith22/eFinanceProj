/*

PLoanRepo.java
Handles repository for PersonalLoan
@Author(s) Frank Smith, Skyler Santiago, Dante Paniccia, Patel Parth

*/
package com.example.efinance.repository;

import com.example.efinance.model.PersonalLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PLoanRepo extends JpaRepository<PersonalLoan,Long> {
    @Query("SELECT u FROM PersonalLoan u WHERE u.user.uid = ?1")
    List<PersonalLoan> findByUser(Long userID);
}
