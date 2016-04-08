package com.gaadi.app.models;

/**
 * Created by kanishroshan on 4/4/16.
 */
public class SearchcarModel {

    long price, kiloMeter;
    long year;

    public SearchcarModel(long kiloMeter, long price, long year) {
        this.kiloMeter = kiloMeter;
        this.price = price;
        this.year = year;
    }

    public long getKiloMeter() {
        return kiloMeter;
    }

    public void setKiloMeter(long kiloMeter) {
        this.kiloMeter = kiloMeter;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}



