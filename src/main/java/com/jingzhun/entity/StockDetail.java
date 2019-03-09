package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDetail implements Serializable {
    private Integer stockDetailId;

    private Integer stockDetailDeviceStyleId;

    private String stockDetailDeviceNumber;

    private String stockDetailState;

    private DeviceStyle deviceStyle;

    private String stockDetailTwoDimensional;


}