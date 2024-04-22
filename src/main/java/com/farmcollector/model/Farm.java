package com.farmcollector.model;

import java.util.HashMap;
import java.util.Map;

public class Farm {

    private String name;
    private Map<String, SeasonData> seasonDataMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlantedData(PlantedData plantedData) {
        SeasonData seasonData = seasonDataMap.computeIfAbsent(plantedData.getSeason(), key -> new SeasonData());
        seasonData.addPlantedData(plantedData);
    }

    public void addHarvestedData(HarvestedData harvestedData) {
        SeasonData seasonData = seasonDataMap.computeIfAbsent(harvestedData.getSeason(), key -> new SeasonData());
        seasonData.addHarvestedData(harvestedData);
    }

    // public Map<String, Map<String, Double>> generateReport() {
    //     Map<String, Map<String, Double>> report = new HashMap<>();
    //     for (Map.Entry<String, SeasonData> entry : seasonDataMap.entrySet()) {
    //         report.put(entry.getKey(), entry.getValue().generateReport());
    //     }
    //     return report;
    // }
    public Map<String, Map<String, Double>> generateReport() {
        Map<String, Map<String, Double>> report = new HashMap<>();
        for (Map.Entry<String, SeasonData> entry : seasonDataMap.entrySet()) {
            String season = entry.getKey();
            Map<String, Double> seasonReport = entry.getValue().generateReport();
            report.put(season, seasonReport);
        }
        return report;
    }
}
