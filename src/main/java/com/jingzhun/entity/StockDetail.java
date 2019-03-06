package com.jingzhun.entity;

import java.io.Serializable;

public class StockDetail implements Serializable {
    private Integer stockDetailId;

    private Integer stockDetailDeviceStyleId;

    private String stockDetailDeviceNumber;

    private String stockDetailState;

    private DeviceStyle deviceStyle;

    private String stockDetailTwoDimensional;

    @Override
    public String toString() {
        return "StockDetail{" +
                "stockDetailId=" + stockDetailId +
                ", stockDetailDeviceStyleId=" + stockDetailDeviceStyleId +
                ", stockDetailDeviceNumber='" + stockDetailDeviceNumber + '\'' +
                ", stockDetailState='" + stockDetailState + '\'' +
                ", deviceStyle=" + deviceStyle +
                ", stockDetailTwoDimensional='" + stockDetailTwoDimensional + '\'' +
                '}';
    }

    public Integer getStockDetailId() {
        return stockDetailId;
    }

    public void setStockDetailId(Integer stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public Integer getStockDetailDeviceStyleId() {
        return stockDetailDeviceStyleId;
    }

    public void setStockDetailDeviceStyleId(Integer stockDetailDeviceStyleId) {
        this.stockDetailDeviceStyleId = stockDetailDeviceStyleId;
    }

    public String getStockDetailDeviceNumber() {
        return stockDetailDeviceNumber;
    }

    public void setStockDetailDeviceNumber(String stockDetailDeviceNumber) {
        this.stockDetailDeviceNumber = stockDetailDeviceNumber;
    }

    public String getStockDetailState() {
        return stockDetailState;
    }

    public void setStockDetailState(String stockDetailState) {
        this.stockDetailState = stockDetailState;
    }

    public DeviceStyle getDeviceStyle() {
        return deviceStyle;
    }

    public void setDeviceStyle(DeviceStyle deviceStyle) {
        this.deviceStyle = deviceStyle;
    }

    public String getStockDetailTwoDimensional() {
        return stockDetailTwoDimensional;
    }

    public void setStockDetailTwoDimensional(String stockDetailTwoDimensional) {
        this.stockDetailTwoDimensional = stockDetailTwoDimensional;
    }
}