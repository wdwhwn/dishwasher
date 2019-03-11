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
public class TokenInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private String token;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Date getCreateTime() {
        if(createTime==null){
            return null;
        }
        return (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        if(createTime==null){
            this.createTime=null;
        }else {
            this.createTime = (Date)createTime.clone();
        }
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Date getUpdateTime() {
        if(updateTime==null){
            return null;
        }
        return (Date)updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        if(updateTime==null){
            this.updateTime=null;
        }else {
            this.updateTime = (Date)updateTime.clone();
        }
    }

    public Date getEffectiveTime() {
        if(effectiveTime==null){
            return null;
        }
        return (Date)effectiveTime.clone();
    }

    public void setEffectiveTime(Date effectiveTime) {
        if(effectiveTime==null){
            this.effectiveTime=null;
        }else {
            this.effectiveTime = (Date)effectiveTime.clone();
        }
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date effectiveTime;


}