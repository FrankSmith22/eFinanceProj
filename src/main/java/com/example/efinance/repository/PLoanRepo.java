package com.example.efinance.repository;

import com.example.efinance.model.PersonalLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PLoanRepo extends JpaRepository<PersonalLoan,Long> {

}
