package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceStyle {
    private Integer deviceStyleId;
    private String devieStyleName;
    private BigDecimal devieStyleMonthSupply;
    private Integer deviceStyleNumber;

}
