package com.codecool.neighbourhood.model;

import java.util.ArrayList;
import java.util.List;

public class County extends AdministrationUnit{
    private int countyID;
    private List<Community> communityList;

    public County(int countyID, String name, String type){
        this.countyID = countyID;
        this.name = name;
        this.type = type;
        this.communityList = new ArrayList<>();
    }

    public int getCountyID() {
        return countyID;
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void addCommunity(Community community){
        communityList.add(community);
    }
}