package com.example.dsm2018.dusty;

public class DustyModel {

    private long d;     //미세먼지 농도
    private long h;     //습도
    private long t;     //온도

    public long getDusty() {
        return this.d;
    }

    public void setDusty(long d) {
        this.d = d;
    }

    public long getHumidity() {
        return this.h;
    }

    public void setHumidity(long h) {
        this.h = h;
    }

    public long getTemperature() {
        return this.t;
    }

    public void setTemperature(long t) {
        this.t = t;
    }

}
