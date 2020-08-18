package com.team.sioh6.ui.sell;

public class SellModel {
    private String productName;
    private String productDetails;
    private String productDate;
    private int status;
    private double lat, lng;

    public SellModel() {
    }

    public SellModel(String productName, String productDetails, String productDate, int status, double lat, double lng) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productDate = productDate;
        this.status = status;
        this.lat = lat;
        this.lng = lng;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
