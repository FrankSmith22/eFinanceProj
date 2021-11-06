package com.example.efinance.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanid;
    @Column(name="full_name")
    private String fullName;
    @Column(name="address_line_1")
    private String addressLine1;
    @Column(name="address_line_2")
    private String addressLine2;
    @Column(name="country")
    private String country;
    @Column(name="state")
    private String state;
    @Column(name="zip_code")
    private String zipCode;
    @Column(name="phone_number")
    private long phoneNumber;
    @Column(name="income")
    private long income;
    @Column(name="loan_length_in_months")
    private long loanLengthInMonths;
    @Column(name="loan_amount")
    private long loanAmount;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getLoanLengthInMonths() {
        return loanLengthInMonths;
    }

    public void setLoanLengthInMonths(long loanLengthInMonths) {
        this.loanLengthInMonths = loanLengthInMonths;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }
}
