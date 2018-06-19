package com.codecool.neighbourhood.view;

import java.util.List;
import java.util.Set;

public class Display {
    public Display(){}


public void show(String str){
    System.out.println(str);
}

public void showStatistics(int[] stats){
        System.out.println(stats[0] + " województwo\n" +
                           stats[1] + " powiaty\n" +
                stats[2] + " gmina miejska\n" +
                stats[3] + " gmina wiejska\n" +
                stats[4] + " gmina miejsko-wiejska\n" +
                stats[5] + " obszar wiejski\n" +
                stats[6] + " miasto\n" +
                stats[7] + " miasto na prawach powiatu\n" +
                stats[8] + " delegatura");
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
    for(String[] location : locations){
        System.out.println(location[0] + ": " + location[1]);
    }
}
}