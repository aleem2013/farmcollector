package com.farmcollector.model;

public class CropData {

    private double plantedArea;
    private String cropType;
    private double expectedProduct;
    private double actualProduct;

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

    public double getActualProduct() {
        return actualProduct;
    }

    public void setActualProduct(double actualProduct) {
        this.actualProduct = actualProduct;
    }

    public void setPlantedData(PlantedData plantedData) {
        this.plantedArea = plantedData.getPlantedArea();
        this.cropType = plantedData.getCropType();
        this.expectedProduct = plantedData.getExpectedProduct();
    }

    public void setHarvestedData(HarvestedData harvestedData) {
        this.actualProduct = harvestedData.getActualProduct();
    }

    public double calculateYield() {
        return actualProduct / expectedProduct;
    }
}
