package com.codecool.neighbourhood.controller;

import com.codecool.neighbourhood.model.*;
import com.codecool.neighbourhood.view.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuHandler {
    private static Display display = new Display();
    private static DataManager dataManager = new DataManager();
    private static List<Voivodeship> voivodeshipList = new ArrayList<>();


    public void run() {
        dataManager.readFileToLists("malopolska.csv");
        createVoivodeships();
        addCountysToVoivodeships();
        addCommunitiesToCountys();
        Statistics statisticsProvider = new Statistics(voivodeshipList, 0);


        display.show("General statistics:");
        int[] stats = statisticsProvider.listStatistics();
        display.showStatistics(stats);

        display.show("\nTop 3 longest name locations:");
        String[] cityNames = statisticsProvider.getLongestCitysNames();
        display.showLongestCityNames(cityNames);

        display.show("\nCounty with the most communities:");
        String countyWithMostCommunitys = statisticsProvider.getCountyWithMostCommunitys();
        display.show(countyWithMostCommunitys);

        display.show("\nLocations belonging to more than one category:");
        Set<String> locations = statisticsProvider.getLocationsWithMoreThanOneCategory();
        display.showSet(locations);

        display.show("Searching for \"Nowy\"");
        List<String[]> searchLocation = statisticsProvider.serach("Nowy");
        display.showSearch(searchLocation);


    }

    public void createVoivodeships() {
        Map<Integer, String> voivodeships = dataManager.getVoivodeships();
        voivodeships.forEach(
                (id, name) -> {
                    Voivodeship voivodeship = new Voivodeship(id, name);
                    voivodeshipList.add(voivodeship);
                });

    }

    public void addCountysToVoivodeships() {
        List<String[]> countiesParams = dataManager.getCounties();
        int voivodeshipIndex = 0;
        int countyIndex = 1;
        int nameIndex = 2;
        int typeIndex = 3;

        for (Voivodeship voivodeship : voivodeshipList) {
            for (String[] countyParams : countiesParams) {
                if (Integer.parseInt(countyParams[voivodeshipIndex]) == (voivodeship.getVoivodeshipID())) {
                    County county = new County(Integer.parseInt(countyParams[countyIndex]),
                                                                countyParams[nameIndex],
                                                                countyParams[typeIndex]);
                    voivodeship.addCounty(county);
                }
            }
        }

    }

    public void addCommunitiesToCountys() {
        List<String[]> communities = dataManager.getCommunities();
        int voivodeshipIndex = 0;
        int countyIndex = 1;
        int communityIndex = 2;
        int communityKindIndex = 3;
        int nameIndex = 4;
        int typeIndex = 5;
        for (Voivodeship voivodeship : voivodeshipList) {
            List<County> counties = voivodeship.getCountyList();
            for (County county : counties) {
                for (String[] communityParams : communities) {
                    if (Integer.parseInt(communityParams[countyIndex]) == (county.getCountyID()) &&
                            Integer.parseInt(communityParams[voivodeshipIndex]) == (voivodeship.getVoivodeshipID())) {
                        Community community = new Community(Integer.parseInt(communityParams[communityIndex]),
                                Integer.parseInt(communityParams[communityKindIndex]),
                                communityParams[nameIndex],
                                communityParams[typeIndex]);
                        county.addCommunity(community);
                    }
                }
            }
        }
    }
}