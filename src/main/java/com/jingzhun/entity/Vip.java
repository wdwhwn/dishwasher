package com.jingzhun.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Vip implements Serializable {
    private Integer vipId;

    private String vipType;

    private BigDecimal vipScore;

    private Integer vipTerm;

    private static final long serialVersionUID = 1L;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public BigDecimal getVipScore() {
        return vipScore;
    }

    public void setVipScore(BigDecimal vipScore) {
        this.vipScore = vipScore;
    }

    public Integer getVipTerm() {
        return vipTerm;
    }

    public void setVipTerm(Integer vipTerm) {
        this.vipTerm = vipTerm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vipId=").append(vipId);
        sb.append(", vipType=").append(vipType);
        sb.append(", vipScore=").append(vipScore);
        sb.append(", vipTerm=").append(vipTerm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}