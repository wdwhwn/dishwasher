package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class Device implements Serializable {
    private Integer deviceId;

    private String deviceName;

    private String deviceNumber;

    private String deviceState;

    private Integer deviceUserId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date devicePurchaseDate;

    public Date getDevicePurchaseDate() {
        if(devicePurchaseDate==null){
            return null;
        }
        return (Date) devicePurchaseDate.clone();
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        if(devicePurchaseDate==null){
            this.devicePurchaseDate=null;
        }else {
            this.devicePurchaseDate = (Date) devicePurchaseDate.clone();
        }
    }

    public Date getDeviceRenewDate() {
        if(deviceRenewDate==null){
            return null;
        }
        return (Date) deviceRenewDate.clone();
    }

    public void setDeviceRenewDate(Date deviceRenewDate) {
        if(deviceRenewDate==null){
            this.deviceRenewDate=null;
        }else{
            this.deviceRenewDate = (Date) deviceRenewDate.clone();
        }

    }

    public Date getDeviceExpireDate() {
        if(deviceRenewDate==null){
            return null;
        }
        return (Date) deviceExpireDate.clone();
    }

    public void setDeviceExpireDate(Date deviceExpireDate) {
        if(deviceExpireDate==null){
            this.deviceRenewDate=null;
        }else{
            this.deviceExpireDate = (Date) deviceExpireDate.clone();

        }
    }

    public Date getDeviceEndDate() {
        if(deviceRenewDate==null){
            return null;
        }
        return (Date) deviceEndDate.clone();
    }

    public void setDeviceEndDate(Date deviceEndDate) {
        if(deviceEndDate==null){
            this.deviceRenewDate=null;
        }else {
            this.deviceEndDate =(Date) deviceEndDate.clone();
        }
    }

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

    private List<DeviceControl> deviceControlList;

}