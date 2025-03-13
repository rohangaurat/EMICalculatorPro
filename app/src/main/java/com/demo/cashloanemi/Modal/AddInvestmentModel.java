package com.demo.cashloanemi.Modal;

public class AddInvestmentModel {
    double balance;
    int id;
    double month;
    double monthlyPayment;
    double rate;
    double startingPayment;
    String title;
    double totalInvestment;

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

    public double getStartingPayment() {
        return this.startingPayment;
    }

    public void setStartingPayment(double d) {
        this.startingPayment = d;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(double d) {
        this.monthlyPayment = d;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double d) {
        this.rate = d;
    }

    public double getMonth() {
        return this.month;
    }

    public void setMonth(double d) {
        this.month = d;
    }

    public double getTotalInvestment() {
        return this.totalInvestment;
    }

    public void setTotalInvestment(double d) {
        this.totalInvestment = d;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double d) {
        this.balance = d;
    }
}
