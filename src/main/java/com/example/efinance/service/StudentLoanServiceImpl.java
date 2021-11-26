package com.example.efinance.service;

import com.example.efinance.model.StudentLoan;
import com.example.efinance.repository.StudentLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoanServiceImpl implements StudentLoanService{

    @Autowired
    private StudentLoanRepository studentLoanRepository;

    @Override
    public void saveStudentLoan(StudentLoan studentLoan) { this.studentLoanRepository.save(studentLoan); }
}
