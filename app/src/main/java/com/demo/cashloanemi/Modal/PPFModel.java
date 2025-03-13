package com.demo.cashloanemi.Modal;

public class PPFModel {
    int id;
    double installment;
    double interestRate;
    double investmentAmount;
    double month;
    String title;

    public double getMonth() {
        return this.month;
    }

    public void setMonth(double d) {
        this.month = d;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double d) {
        this.interestRate = d;
    }

    public double getInvestmentAmount() {
        return this.investmentAmount;
    }

    public void setInvestmentAmount(double d) {
        this.investmentAmount = d;
    }

    public double getInstallment() {
        return this.installment;
    }

    public void setInstallment(double d) {
        this.installment = d;
    }

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
}
