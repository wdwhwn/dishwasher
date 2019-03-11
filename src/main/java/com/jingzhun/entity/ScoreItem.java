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
public class ScoreItem implements Serializable {
    private Integer scoreItemId;

    private String scoreItemType;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scoreItemDate;

    public Date getScoreItemDate() {
        if(scoreItemDate==null){
            return  null;
        }
        return (Date) scoreItemDate.clone();
    }

    public void setScoreItemDate(Date scoreItemDate) {
        if(scoreItemDate==null){
            this.scoreItemDate=null;
        }else{
            this.scoreItemDate = (Date) scoreItemDate.clone();
        }
    }

    private BigDecimal scoreItemScore;

    private String scoreItemState;

    private Integer scoreItemUserId;

    private Integer scoreItemDeviceId;

    private Device device;
}