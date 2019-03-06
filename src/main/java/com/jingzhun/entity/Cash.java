package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Cash implements Serializable {
    private Integer cashId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cashDate;

    private BigDecimal cashScore;

    private String cashState;

    private Integer cashAccountId;

    private Integer cashUserId;

    public Cash() {
    }

    public Cash(Integer cashId, Date cashDate, BigDecimal cashScore, String cashState, Integer cashAccountId, Integer cashUserId) {
        this.cashId = cashId;
        this.cashDate = cashDate;
        this.cashScore = cashScore;
        this.cashState = cashState;
        this.cashAccountId = cashAccountId;
        this.cashUserId = cashUserId;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCashId() {
        return cashId;
    }

    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    public Date getCashDate() {
        return cashDate;
    }

    public void setCashDate(Date cashDate) {
        this.cashDate = cashDate;
    }

    public BigDecimal getCashScore() {
        return cashScore;
    }

    public void setCashScore(BigDecimal cashScore) {
        this.cashScore = cashScore;
    }

    public String getCashState() {
        return cashState;
    }

    public void setCashState(String cashState) {
        this.cashState = cashState;
    }

    public Integer getCashAccountId() {
        return cashAccountId;
    }

    public void setCashAccountId(Integer cashAccountId) {
        this.cashAccountId = cashAccountId;
    }

    public Integer getCashUserId() {
        return cashUserId;
    }

    public void setCashUserId(Integer cashUserId) {
        this.cashUserId = cashUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cashId=").append(cashId);
        sb.append(", cashDate=").append(cashDate);
        sb.append(", cashScore=").append(cashScore);
        sb.append(", cashState=").append(cashState);
        sb.append(", cashAccountId=").append(cashAccountId);
        sb.append(", cashUserId=").append(cashUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}