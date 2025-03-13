package com.demo.cashloanemi.Modal;

public class emiLoanModal {
    double emiLoanAmount;
    double emiLoanMonths;
    double emiLoanRate;
    String emiLoanTitle;
    int id;

    public String getEmiLoanTitle() {
        return this.emiLoanTitle;
    }

    public void setEmiLoanTitle(String str) {
        this.emiLoanTitle = str;
    }

    public double getEmiLoanRate() {
        return this.emiLoanRate;
    }

    public void setEmiLoanRate(double d) {
        this.emiLoanRate = d;
    }

    public double getEmiLoanAmount() {
        return this.emiLoanAmount;
    }

    public void setEmiLoanAmount(double d) {
        this.emiLoanAmount = d;
    }

    public double getEmiLoanMonths() {
        return this.emiLoanMonths;
    }

    public void setEmiLoanMonths(double d) {
        this.emiLoanMonths = d;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }
}
