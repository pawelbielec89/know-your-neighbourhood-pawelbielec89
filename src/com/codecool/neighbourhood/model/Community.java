package com.codecool.neighbourhood.model;

public class Community{
    private int community;
    private int communityType;
    private String name;
    private String type;

    public Community(int community, int communityType, String name, String type){
        this.community = community;
        this.communityType = communityType;
        this.name = name;
        this.type = type;
    }

    public int getCommunity() {
        return community;
    }

    public int getCommunityType() {
        return communityType;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}