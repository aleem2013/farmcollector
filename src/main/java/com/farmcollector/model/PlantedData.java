package com.farmcollector.model;

public class PlantedData {

    private String farmName;
    private String season;
    private double plantedArea;
    private String cropType;
    private double expectedProduct;

    public String getFarmName() {
        return farmName;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    public double getPlantedArea() {
        return plantedArea;
    }
    public void setPlantedArea(double plantedArea) {
        this.plantedArea = plantedArea;
    }
    public String getCropType() {
        return cropType;
    }
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }
    public double getExpectedProduct() {
        return expectedProduct;
    }
    public void setExpectedProduct(double expectedProduct) {
        this.expectedProduct = expectedProduct;
    }

    

}
