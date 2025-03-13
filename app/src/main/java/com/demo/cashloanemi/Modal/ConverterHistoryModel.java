package com.demo.cashloanemi.Modal;

public class ConverterHistoryModel {
    String fromAmount;
    String fromCode;
    int id;
    int isFavorite;
    String time;
    String toAmount;
    String toCode;

    public int getIsFavorite() {
        return this.isFavorite;
    }

    public void setIsFavorite(int i) {
        this.isFavorite = i;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getFromCode() {
        return this.fromCode;
    }

    public void setFromCode(String str) {
        this.fromCode = str;
    }

    public String getToCode() {
        return this.toCode;
    }

    public void setToCode(String str) {
        this.toCode = str;
    }

    public String getFromAmount() {
        return this.fromAmount;
    }

    public void setFromAmount(String str) {
        this.fromAmount = str;
    }

    public String getToAmount() {
        return this.toAmount;
    }

    public void setToAmount(String str) {
        this.toAmount = str;
    }
}
