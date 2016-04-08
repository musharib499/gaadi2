package com.gaadi.app.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mushareb Ali on 5/4/16.
 */
public class SearchMakeModel implements Serializable {

    private String make, model;
    private ArrayList<String> arrayListModel;

    public ArrayList<String> getArrayListModel() {
        return arrayListModel;
    }

    public void setArrayListModel(ArrayList<String> arrayListModel) {
        this.arrayListModel = arrayListModel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
