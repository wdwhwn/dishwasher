package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Device implements Serializable {
    private Integer deviceId;

    private String deviceName;

    private String deviceNumber;

    private String deviceState;

    private Integer deviceUserId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date devicePurchaseDate;
@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceRenewDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceExpireDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceEndDate;

    private Integer deviceStyleId;



    public Integer getDeviceStyleId() {
        return deviceStyleId;
    }

    public void setDeviceStyleId(Integer deviceStyleId) {
        this.deviceStyleId = deviceStyleId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", deviceState='" + deviceState + '\'' +
                ", deviceUserId=" + deviceUserId +
                ", devicePurchaseDate=" + devicePurchaseDate +
                ", deviceRenewDate=" + deviceRenewDate +
                ", deviceExpireDate=" + deviceExpireDate +
                ", deviceEndDate=" + deviceEndDate +
                ", deviceStyle='" + deviceStyleId + '\'' +
                ", deviceControlList=" + deviceControlList +
                '}';
    }

    private List<DeviceControl> deviceControlList;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public Integer getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(Integer deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public Date getDeviceRenewDate() {
        return deviceRenewDate;
    }

    public void setDeviceRenewDate(Date deviceRenewDate) {
        this.deviceRenewDate = deviceRenewDate;
    }

    public Date getDeviceExpireDate() {
        return deviceExpireDate;
    }

    public void setDeviceExpireDate(Date deviceExpireDate) {
        this.deviceExpireDate = deviceExpireDate;
    }

    public Date getDeviceEndDate() {
        return deviceEndDate;
    }

    public void setDeviceEndDate(Date deviceEndDate) {
        this.deviceEndDate = deviceEndDate;
    }



    public List<DeviceControl> getDeviceControlList() {
        return deviceControlList;
    }

    public void setDeviceControlList(List<DeviceControl> deviceControlList) {
        this.deviceControlList = deviceControlList;
    }
}