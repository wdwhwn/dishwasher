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

    private String deviceStatus;

    private Integer deviceUserId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceDate;

    private List<DeviceControl> deviceControlList;


    public Device() {

    }

    public Device(Integer deviceId, String deviceName, String deviceNumber, String deviceStatus, Integer deviceUserId, Date deviceDate, List<DeviceControl> deviceControlList) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceNumber = deviceNumber;
        this.deviceStatus = deviceStatus;
        this.deviceUserId = deviceUserId;
        this.deviceDate = deviceDate;
        this.deviceControlList = deviceControlList;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", deviceUserId=" + deviceUserId +
                ", deviceDate=" + deviceDate +
                ", deviceControlList=" + deviceControlList +
                '}';
    }

    public List<DeviceControl> getDeviceControlList() {
        return deviceControlList;
    }

    public void setDeviceControlList(List<DeviceControl> deviceControlList) {
        this.deviceControlList = deviceControlList;
    }

    private static final long serialVersionUID = 1L;

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

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(Integer deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    public Date getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(Date deviceDate) {
        this.deviceDate = deviceDate;
    }

}