package com.demo.cashloanemi.Modal;

public class ResultModel {
    Double EUR;
    Double rate;

    public Double getEUR() {
        return this.EUR;
    }

    public Double getRate() {
        return this.rate;
    }

    public ResultModel(double d, double d2) {
        this.EUR = Double.valueOf(d);
        this.rate = Double.valueOf(d2);
    }
}
