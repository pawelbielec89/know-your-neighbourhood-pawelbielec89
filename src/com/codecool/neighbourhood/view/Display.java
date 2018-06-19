package com.codecool.neighbourhood.view;

import java.util.List;
import java.util.Set;

public class Display {
    public Display(){}


public void show(String str){
    System.out.println(str);
}

    public void showStatistics(List<String[]> stats){


        System.out.format("/------------------------------------\\%n");
        String leftAlignFormat = "|  %-33s |%n";
        System.out.format(leftAlignFormat, stats.get(0)[0]);
        leftAlignFormat = "| %-5s | %-26s |%n";
        for (int i = 1; i < stats.size(); i++){
        System.out.format("+-------+----------------------------+%n");

            System.out.format(leftAlignFormat,stats.get(i)[0], stats.get(i)[1]);
        }
        System.out.format("\\------+-----------------------------/%n");

    }

public void showLongestCityNames(String[] names){
        System.out.println(names[0]+"\n"+
                            names[1]+"\n"+
                            names[2]);
}
public void showSet(Set<String> elements){
        for (String str : elements){
            System.out.println(str);
        }
}

    public void showSearch(List<String[]> locations){
        String leftAlignFormat = "| %-22s | %-27s |%n";

        System.out.format("/------------------------------------------------------\\%n");
        System.out.format("|      Location          |           Type              |%n");
        System.out.format("+------------------------+-----------------------------+%n");

        for (int i = 0; i < locations.size(); i++){
            System.out.format(leftAlignFormat,locations.get(i)[0], locations.get(i)[1]);
        }
        System.out.format("\\------------------------+-----------------------------/%n");

    }
}
