package com.team.sioh6.ui.tools;

public class StoreModel {
    private String storeName;
    private String storeLocation;
    private double storeLat;
    private double storeLong;

    public StoreModel() {
    }

    public StoreModel(String storeName, String storeLocation, double storeLat, double storeLong) {
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeLat = storeLat;
        this.storeLong = storeLong;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public double getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(double storeLat) {
        this.storeLat = storeLat;
    }

    public double getStoreLong() {
        return storeLong;
    }

    public void setStoreLong(double storeLong) {
        this.storeLong = storeLong;
    }
}
