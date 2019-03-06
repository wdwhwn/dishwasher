package com.jingzhun.entity;

import java.io.Serializable;

public class StockDetail implements Serializable {
    private Integer stockDetailId;

    private Integer stockDetailDeviceStyleId;

    private String stockDetailDeviceNumber;

    private String stockDetailState;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "StockDetail{" +
                "stockDetailId=" + stockDetailId +
                ", stockDetailDeviceStyleId=" + stockDetailDeviceStyleId +
                ", stockDetailDeviceNumber='" + stockDetailDeviceNumber + '\'' +
                ", stockDetailState='" + stockDetailState + '\'' +
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StockDetail() {
    }

    public StockDetail(Integer stockDetailId, Integer stockDetailDeviceStyleId, String stockDetailDeviceNumber, String stockDetailState) {
        this.stockDetailId = stockDetailId;
        this.stockDetailDeviceStyleId = stockDetailDeviceStyleId;
        this.stockDetailDeviceNumber = stockDetailDeviceNumber;
        this.stockDetailState = stockDetailState;
    }
}