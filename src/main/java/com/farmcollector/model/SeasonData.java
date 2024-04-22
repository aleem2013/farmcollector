package com.farmcollector.model;

import java.util.HashMap;
import java.util.Map;

public class SeasonData {
    private Map<String, CropData> cropDataMap = new HashMap<>();

        public void addPlantedData(PlantedData plantedData) {
            cropDataMap.computeIfAbsent(plantedData.getCropType(), key -> new CropData()).setPlantedData(plantedData);
        }

        public void addHarvestedData(HarvestedData harvestedData) {
            cropDataMap.computeIfAbsent(harvestedData.getCropType(), key -> new CropData()).setHarvestedData(harvestedData);
        }

        public Map<String, Double> generateReport() {
            Map<String, Double> report = new HashMap<>();
            for (Map.Entry<String, CropData> entry : cropDataMap.entrySet()) {
                report.put(entry.getKey(), entry.getValue().calculateYield());
            }
            return report;
        }


}
