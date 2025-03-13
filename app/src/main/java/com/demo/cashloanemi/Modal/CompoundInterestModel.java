package com.demo.cashloanemi.Modal;

public class CompoundInterestModel {
    int id;
    double interestRate;
    double loanAmount;
    String title;
    double year;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(double d) {
        this.loanAmount = d;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double d) {
        this.interestRate = d;
    }

    public double getYear() {
        return this.year;
    }

    public void setYear(double d) {
        this.year = d;
    }
}
