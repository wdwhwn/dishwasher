package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class DeviceControl implements Serializable {
    private Integer deviceControlId;

    private Integer deviceControlDeviceId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deviceControlDate;

    public Date getDeviceControlDate() {
        if(deviceControlDate==null){
            return null;
        }
        return (Date) deviceControlDate.clone();
    }

    public void setDeviceControlDate(Date deviceControlDate) {
        if(deviceControlDate==null){
            this.deviceControlDate=null;
        }else{
            this.deviceControlDate = deviceControlDate;

        }
    }

    private String deviceControlState;

    private Device device;
}