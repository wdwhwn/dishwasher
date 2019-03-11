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
public class Cash implements Serializable {
    private Integer cashId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cashDate;

    public Date getCashDate() {
        if(cashDate==null){
            return null;
        }
        return (Date) cashDate.clone();
    }

    public void setCashDate(Date cashDate) {
        if(cashDate==null){
            this.cashDate=null;
        }else{
            this.cashDate=(Date)cashDate.clone();
        }
    }

    private BigDecimal cashScore;

    private String cashState;

    private Integer cashAccountId;

    private Integer cashUserId;


}