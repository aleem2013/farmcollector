package com.farmcollector.model;



public class HarvestedData {

    private String farmName;
    private String season;
    private String cropType;
    private double actualProduct;

    public String getFarmName() {
        return farmName;
    }
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    
    public String getCropType() {
        return cropType;
    }
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }
    public double getActualProduct() {
        return actualProduct;
    }
    public void setActualProduct(double actualProduct) {
        this.actualProduct = actualProduct;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }


    
}
