package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class Order implements Serializable {
    private Integer orderId;

    private String orderMessage;

    private String orderFreight;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderDate;

    public Date getOrderDate() {
        if(orderDate==null){
            return null;
        }
        return (Date) orderDate.clone();
    }

    public void setOrderDate(Date orderDate) {
        if(orderDate==null){
            this.orderDate=null;
        }else{
            this.orderDate = (Date) orderDate.clone();
        }
    }

    private BigDecimal orderTotalPrice;

    private Integer orderAddressId;

    private Integer orderUserId;


}