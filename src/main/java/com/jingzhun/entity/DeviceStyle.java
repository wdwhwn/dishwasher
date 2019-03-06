package com.jingzhun.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
public class DeviceStyle {
    private Integer deviceStyleId;
    private String devieStyleName;
    private BigDecimal devieStyleMonthSupply;
    private Integer deviceStyleNumber;

    @Override
    public String toString() {
        return "DeviceStyle{" +
                "deviceStyleId=" + deviceStyleId +
                ", devieStyleName='" + devieStyleName + '\'' +
                ", devieStyleMonthSupply=" + devieStyleMonthSupply +
                ", deviceStyleNumber=" + deviceStyleNumber +
                '}';
    }

    public Integer getDeviceStyleId() {
        return deviceStyleId;
    }

    public void setDeviceStyleId(Integer deviceStyleId) {
        this.deviceStyleId = deviceStyleId;
    }

    public String getDevieStyleName() {
        return devieStyleName;
    }

    public void setDevieStyleName(String devieStyleName) {
        this.devieStyleName = devieStyleName;
    }

    public BigDecimal getDevieStyleMonthSupply() {
        return devieStyleMonthSupply;
    }

    public void setDevieStyleMonthSupply(BigDecimal devieStyleMonthSupply) {
        this.devieStyleMonthSupply = devieStyleMonthSupply;
    }

    public Integer getDeviceStyleNumber() {
        return deviceStyleNumber;
    }

    public void setDeviceStyleNumber(Integer deviceStyleNumber) {
        this.deviceStyleNumber = deviceStyleNumber;
    }

    public DeviceStyle() {
    }

    public DeviceStyle(Integer deviceStyleId, String devieStyleName, BigDecimal devieStyleMonthSupply, Integer deviceStyleNumber) {
        this.deviceStyleId = deviceStyleId;
        this.devieStyleName = devieStyleName;
        this.devieStyleMonthSupply = devieStyleMonthSupply;
        this.deviceStyleNumber = deviceStyleNumber;
    }
}
