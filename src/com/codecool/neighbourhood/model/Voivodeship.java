package com.codecool.neighbourhood.model;

import java.util.ArrayList;
import java.util.List;

public class Voivodeship extends AdministrationUnit{
    private int voivodeshipID;
    private List<County> countryList;

    public Voivodeship(int voivodeshipID, String name){
        this.voivodeshipID = voivodeshipID;
        this.name = name;
        this.countryList = new ArrayList<>();
    }

    public int getVoivodeshipID() {
        return voivodeshipID;
    }

    public List<County> getCountyList() {
        return countryList;
    }

    public void addCounty(County county){
        countryList.add(county);
    }
}