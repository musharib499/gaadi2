package com.gaadi.app.models;

/**
 * Created by kanishroshan on 29/3/16.
 */
public class CarsDetails {

    private String carName;
    private String carAddress;
    private String carPrice;

    public CarsDetails(String carName, String carAdress, String carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.carAddress = carAdress;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarAddress() {
        return carAddress;
    }

    public void setCarAddress(String carAddress) {
        this.carAddress = carAddress;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}
