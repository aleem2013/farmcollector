package com.farmcollector.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.farmcollector.model.Farm;
import com.farmcollector.model.HarvestedData;
import com.farmcollector.model.PlantedData;

//import org.springframework.beans.factory.annotation.Autowired;


@Service
public class FarmServiceImpl implements FarmService {

    private final Map<String, Farm> farms = new HashMap<>();

    @Override
    public void addPlantedData(PlantedData plantedData) {
        Farm farm = farms.computeIfAbsent(plantedData.getFarmName(), key -> new Farm());
        farm.addPlantedData(plantedData);
    }

    @Override
    public void addHarvestedData(HarvestedData harvestedData) {
        Farm farm = farms.computeIfAbsent(harvestedData.getFarmName(), key -> new Farm());
        farm.addHarvestedData(harvestedData);
    }

    @Override
    public Map<String, Map<String, Double>> generateReportByFarm() {
        Map<String, Map<String, Double>> report = new HashMap<>();
        for (Map.Entry<String, Farm> entry : farms.entrySet()) {
            String farmName = entry.getKey();
            Farm farm = entry.getValue();
            Map<String, Double> farmReport = new HashMap<>();
            farm.generateReport().forEach((season, cropReport) -> {
                cropReport.forEach((cropType, totalProduct) -> {
                    farmReport.put(season + " - " + cropType, totalProduct);
                });
            });
            report.put(farmName, farmReport);
        }
        return report;
    }


    @Override
    public Map<String, Map<String, Double>> generateReportByCropType() {
        Map<String, Map<String, Double>> report = new HashMap<>();
        for (Map.Entry<String, Farm> entry : farms.entrySet()) {
            String farmName = entry.getKey();
            Farm farm = entry.getValue();
            Map<String, Map<String, Double>> farmReport = farm.generateReport(); // Report for the current farm
            for (Map.Entry<String, Map<String, Double>> seasonEntry : farmReport.entrySet()) {
                String season = seasonEntry.getKey();
                Map<String, Double> seasonReport = seasonEntry.getValue();
                for (Map.Entry<String, Double> cropEntry : seasonReport.entrySet()) {
                    String cropType = cropEntry.getKey();
                    double totalProduct = cropEntry.getValue();
                    report.computeIfAbsent(cropType, key -> new HashMap<>()).put(farmName + " - " + season, totalProduct);
                }
            }
        }
        return report;
    }


}
