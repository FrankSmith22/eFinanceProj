package com.example.efinance.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="studentLoan")
public class StudentLoan extends Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanid;
    @Column(name="school_name")
    private String schoolName;
    @Column(name="gpa")
    private long gpa;
    @Column(name="num_semesters")
    private long numSemesters;
}
