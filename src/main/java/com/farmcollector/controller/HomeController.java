package com.farmcollector.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmcollector.model.HarvestedData;
import com.farmcollector.model.PlantedData;
import com.farmcollector.service.FarmService;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private final FarmService farmService;

    public HomeController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/planted")
    public ResponseEntity<Void> addPlantedData(@RequestBody PlantedData plantedData) {
        farmService.addPlantedData(plantedData);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/harvested")
    public ResponseEntity<Void> addHarvestedData(@RequestBody HarvestedData harvestedData) {
        farmService.addHarvestedData(harvestedData);
        return ResponseEntity.ok().build();
    }

     @GetMapping("/report/by-farm")
    public Map<String, Map<String, Double>> getReportByFarm() {
        return farmService.generateReportByFarm();
    }

    @GetMapping("/report/by-crop-type")
    public Map<String, Map<String, Double>> getReportByCropType() {
        return farmService.generateReportByCropType();
    }

    // @GetMapping("/report")
    // public Map<String, Map<String, Double>> generateReport() {
    //     Map<String, Map<String, Double>> report = new HashMap<>();
    //     for (Farm farm : farms.values()) {
    //         report.put(farm.getName(), farm.generateReport());
    //     }
    //     return report;
    // }

}
