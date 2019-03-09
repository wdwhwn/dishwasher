package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Integer orderId;

    private String orderMessage;

    private String orderFreight;

    private Date orderDate;

    private BigDecimal orderTotalPrice;

    private Integer orderAddressId;

    private Integer orderUserId;


}