package com.codecool.neighbourhood.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataManager {

    private Map<Integer, String> voivodeships; //wojewodztwa
    private List<String[]> counties; //powiaty
    private List<String[]> communities; //gminy

    public DataManager() {
        this.voivodeships = new HashMap<>();
        this.counties = new ArrayList<>();
        this.communities = new ArrayList<>();
    }

    public void readFileToLists(String filename) {
        Path filePath = Paths.get("", filename);
        try {
            Scanner reader = new Scanner(filePath);
            reader.nextLine();  // Skip header
            while (reader.hasNext()) {
                String[] inputEntry = reader.nextLine().split("\t");
                List<String> params = new ArrayList<>();
                for (int i = 0; i< inputEntry.length; i++){
                    if(!inputEntry[i].isEmpty()){
                        params.add(inputEntry[i]);
                        }
                    }
                String[] entry = new String[params.size()];
                entry = params.toArray(entry);
                if (entry.length == 3) {
                    int ID = Integer.parseInt(entry[0]);
                    voivodeships.put(ID, entry[1]);
                } else if (entry.length == 4) {
                    counties.add(entry);
                } else if (entry.length > 4) {
                    communities.add(entry);
                    int entryLength = entry.length;
                    String trim = entry[entryLength - 1].trim();
                    entry[entryLength - 1] = trim;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String[]> getCommunities() {
        return communities;
    }

    public List<String[]> getCounties() {
        return counties;
    }

    public Map<Integer, String> getVoivodeships() {
        return this.voivodeships;
    }
}
