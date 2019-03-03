package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ScoreItem implements Serializable {
    private Integer scoreItemId;

    private String scoreItemType;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scoreItemDate;

    private String scoreItemScore;

    private String scoreItemState;

    private Integer scoreItemUserId;

    private static final long serialVersionUID = 1L;

    public Integer getScoreItemId() {
        return scoreItemId;
    }

    public void setScoreItemId(Integer scoreItemId) {
        this.scoreItemId = scoreItemId;
    }

    public String getScoreItemType() {
        return scoreItemType;
    }

    public void setScoreItemType(String scoreItemType) {
        this.scoreItemType = scoreItemType;
    }

    public Date getScoreItemDate() {
        return scoreItemDate;
    }

    public void setScoreItemDate(Date scoreItemDate) {
        this.scoreItemDate = scoreItemDate;
    }

    public String getScoreItemScore() {
        return scoreItemScore;
    }

    public void setScoreItemScore(String scoreItemScore) {
        this.scoreItemScore = scoreItemScore;
    }

    public String getScoreItemState() {
        return scoreItemState;
    }

    public void setScoreItemState(String scoreItemState) {
        this.scoreItemState = scoreItemState;
    }

    public Integer getScoreItemUserId() {
        return scoreItemUserId;
    }

    public void setScoreItemUserId(Integer scoreItemUserId) {
        this.scoreItemUserId = scoreItemUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scoreItemId=").append(scoreItemId);
        sb.append(", scoreItemType=").append(scoreItemType);
        sb.append(", scoreItemDate=").append(scoreItemDate);
        sb.append(", scoreItemScore=").append(scoreItemScore);
        sb.append(", scoreItemState=").append(scoreItemState);
        sb.append(", scoreItemUserId=").append(scoreItemUserId);
        sb.append("]");
        return sb.toString();
    }
}