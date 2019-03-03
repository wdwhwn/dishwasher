package com.jingzhun.entity;

import java.io.Serializable;

public class Ratio implements Serializable {
    private Integer ratioId;

    private String ratioRatio;

    private String ratioStatus;

    private static final long serialVersionUID = 1L;

    public Integer getRatioId() {
        return ratioId;
    }

    public void setRatioId(Integer ratioId) {
        this.ratioId = ratioId;
    }

    public String getRatioRatio() {
        return ratioRatio;
    }

    public void setRatioRatio(String ratioRatio) {
        this.ratioRatio = ratioRatio;
    }

    public String getRatioStatus() {
        return ratioStatus;
    }

    public void setRatioStatus(String ratioStatus) {
        this.ratioStatus = ratioStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ratioId=").append(ratioId);
        sb.append(", ratioRatio=").append(ratioRatio);
        sb.append(", ratioStatus=").append(ratioStatus);
        sb.append("]");
        return sb.toString();
    }
}