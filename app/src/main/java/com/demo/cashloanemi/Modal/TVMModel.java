package com.demo.cashloanemi.Modal;

public class TVMModel {
    double futureValue;
    int id;
    double installment;
    double mode;
    double payment;
    double presentValue;
    double rate;
    double select;
    String title;
    double year;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public double getFutureValue() {
        return this.futureValue;
    }

    public void setFutureValue(double d) {
        this.futureValue = d;
    }

    public double getPresentValue() {
        return this.presentValue;
    }

    public void setPresentValue(double d) {
        this.presentValue = d;
    }

    public double getPayment() {
        return this.payment;
    }

    public void setPayment(double d) {
        this.payment = d;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double d) {
        this.rate = d;
    }

    public double getYear() {
        return this.year;
    }

    public void setYear(double d) {
        this.year = d;
    }

    public double getInstallment() {
        return this.installment;
    }

    public void setInstallment(double d) {
        this.installment = d;
    }

    public double getMode() {
        return this.mode;
    }

    public void setMode(double d) {
        this.mode = d;
    }

    public double getSelect() {
        return this.select;
    }

    public void setSelect(double d) {
        this.select = d;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }
}
