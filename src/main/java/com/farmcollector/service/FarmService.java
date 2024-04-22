package com.farmcollector.service;

import java.util.Map;

import com.farmcollector.model.HarvestedData;
import com.farmcollector.model.PlantedData;

public interface FarmService {

    void addPlantedData(PlantedData plantedData);
    void addHarvestedData(HarvestedData harvestedData);
    Map<String, Map<String, Double>> generateReportByFarm();
    Map<String, Map<String, Double>> generateReportByCropType();
}
