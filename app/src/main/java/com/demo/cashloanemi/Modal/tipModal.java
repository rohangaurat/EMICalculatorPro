package com.demo.cashloanemi.Modal;

public class tipModal {
    double billAmount;
    int id;
    double split;
    double taxRate;
    double tipRate;
    String title;

    public double getBillAmount() {
        return this.billAmount;
    }

    public void setBillAmount(double d) {
        this.billAmount = d;
    }

    public double getTipRate() {
        return this.tipRate;
    }

    public void setTipRate(double d) {
        this.tipRate = d;
    }

    public double getSplit() {
        return this.split;
    }

    public void setSplit(double d) {
        this.split = d;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(double d) {
        this.taxRate = d;
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
