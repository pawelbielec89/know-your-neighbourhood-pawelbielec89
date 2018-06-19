package com.codecool.neighbourhood.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Statistics {
    private static List<Voivodeship> voivodeshipList;
    private int index;

    public Statistics(List<Voivodeship> voivodeshipList, int index) {

        this.voivodeshipList = voivodeshipList;
        this.index = index;
    }

    public int[] listStatistics() {
        int[] listedStatistics = new int[9];
        listedStatistics[0] = voivodeshipList.size();
        listedStatistics[1] = voivodeshipList.get(index).getCountyList().size();
        listedStatistics[2] = countCommunityTypeAmount("gmina miejska");
        listedStatistics[3] = countCommunityTypeAmount("gmina wiejska");
        listedStatistics[4] = countCommunityTypeAmount("gmina miejsko-wiejska");
        listedStatistics[5] = countCommunityTypeAmount("obszar wiejski");
        listedStatistics[6] = countCommunityTypeAmount("miasto");
        listedStatistics[7] = countCitysOnCountyRights();
        listedStatistics[8] = countCommunityTypeAmount("delegatura");
        return listedStatistics;
    }

    private int countCommunityTypeAmount(String str) {
        int counter = 0;
        for (County county : voivodeshipList.get(index).getCountyList()) {
            for (Community community : county.getCommunityList()) {
                if (community.getType().equalsIgnoreCase(str)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int countCitysOnCountyRights() {
        int counter = 0;
        for (County county : voivodeshipList.get(index).getCountyList()) {
            if (county.getType().equalsIgnoreCase("miasto na prawach powiatu")) {
                counter++;
            }
        }
        return counter;
    }

    public String[] getLongestCitysNames() {
        String[] longestCityNames = new String[3];
        longestCityNames[0] = "";
        longestCityNames[1] = "";
        longestCityNames[2] = "";
        for (County county : voivodeshipList.get(index).getCountyList()) {
            for (Community community : county.getCommunityList()) {
                if (community.getType().equalsIgnoreCase("miasto")) {
                    if (community.getName().length() > longestCityNames[0].length() ||
                            community.getName().length() > longestCityNames[1].length() ||
                            community.getName().length() > longestCityNames[2].length()) {
                        int shortestIndex = shortestCityName(longestCityNames);
                        longestCityNames[shortestIndex] = community.getName();
                    }
                }
            }
        }
        return longestCityNames;
    }

    private int shortestCityName(String[] citys) {
        if (citys[0].length() <= citys[1].length() && citys[0].length() <= citys[2].length()) {
            return 0;
        } else if (citys[1].length() <= citys[0].length() && citys[1].length() <= citys[2].length()) {
            return 1;
        } else if (citys[2].length() <= citys[0].length() && citys[2].length() <= citys[1].length()) {
            return 2;
        }
        return 0;
    }

    public Set<String> getLocationsWithMoreThanOneCategory() {
        Set<String> locationsWithMoreThanOneCategory = new HashSet<>();
        Set<String> locations = new HashSet<>();
        for (County county : voivodeshipList.get(index).getCountyList()) {
            for (Community community : county.getCommunityList()) {
                if(locations.contains(community.getName())){
                    locationsWithMoreThanOneCategory.add(community.getName());
                } else{
                    locations.add(community.getName());
                }
            }

        }
        for(String str: locationsWithMoreThanOneCategory) {
            System.out.println(str);
        }
        return locationsWithMoreThanOneCategory;
    }
    public String getCountyWithMostCommunitys(){
        int communitysAmount = 0;
        String countyName = "";
        for (County county : voivodeshipList.get(index).getCountyList()){
            if(county.getCommunityList().size()>communitysAmount){
                communitysAmount = county.getCommunityList().size();
                countyName = county.getName();
            }
        }
        return countyName;
    }
    public List<String[]> serach(String str){
        List<String[]> results = new ArrayList<>();
        int listIndex = 0;
        for (County county : voivodeshipList.get(index).getCountyList()){
            if(county.getName().toLowerCase().contains(str.toLowerCase())){
                String[] location = new String[2];
                location[0] = county.getName();
                location[1] = county.getType();
                results.add(listIndex, location);
                listIndex++;
            }
        }
        for (County county : voivodeshipList.get(index).getCountyList()) {
            for (Community community : county.getCommunityList()){
                if(community.getName().toLowerCase().contains(str.toLowerCase())){
                    String[] location = new String[2];
                    location[0] = community.getName();
                    location[1] = community.getType();
                    results.add(listIndex, location);
                    listIndex++;
            }
    }
}
return results;
    }
}