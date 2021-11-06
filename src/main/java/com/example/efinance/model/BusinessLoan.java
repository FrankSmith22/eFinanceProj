package com.example.efinance.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="businessLoan")
public class BusinessLoan extends Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanid;
    @Column(name="company_name")
    private String companyName;
    @Column(name="num_employees")
    private String numEmployees;
    @Column(name="revenue")
    private String revenue;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(String numEmployees) {
        this.numEmployees = numEmployees;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}
