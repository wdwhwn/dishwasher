package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class DeviceControl implements Serializable {
    private Integer deviceControlId;

    private Integer deviceControlDeviceId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceControlDate;

    private String deviceControlState;

    private static final long serialVersionUID = 1L;

    public Integer getDeviceControlId() {
        return deviceControlId;
    }

    public void setDeviceControlId(Integer deviceControlId) {
        this.deviceControlId = deviceControlId;
    }

    public Integer getDeviceControlDeviceId() {
        return deviceControlDeviceId;
    }

    public void setDeviceControlDeviceId(Integer deviceControlDeviceId) {
        this.deviceControlDeviceId = deviceControlDeviceId;
    }

    public Date getDeviceControlDate() {
        return deviceControlDate;
    }

    public void setDeviceControlDate(Date deviceControlDate) {
        this.deviceControlDate = deviceControlDate;
    }

    public String getDeviceControlState() {
        return deviceControlState;
    }

    public void setDeviceControlState(String deviceControlState) {
        this.deviceControlState = deviceControlState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceControlId=").append(deviceControlId);
        sb.append(", deviceControlDeviceId=").append(deviceControlDeviceId);
        sb.append(", deviceControlDate=").append(deviceControlDate);
        sb.append(", deviceControlState=").append(deviceControlState);
        sb.append("]");
        return sb.toString();
    }
}