package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userWxImg;

    private String userWxName;

    private BigDecimal userTotalScore;

    private BigDecimal userCurrentScore;

    private BigDecimal userConsumeScore;

    private Integer userPid;

    private Integer userVipId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date userDate;

    private String userType="0";

    private String userPassword;

    private String userDeleteState="0";

    private List<Account> accountList;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userWxImg='" + userWxImg + '\'' +
                ", userWxName='" + userWxName + '\'' +
                ", userTotalScore=" + userTotalScore +
                ", userCurrentScore=" + userCurrentScore +
                ", userConsumeScore=" + userConsumeScore +
                ", userPid=" + userPid +
                ", userVipId=" + userVipId +
                ", userDate=" + userDate +
                ", userType='" + userType + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userDeleteState='" + userDeleteState + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public User(Integer userId, String userName, String userWxImg, String userWxName, BigDecimal userTotalScore, BigDecimal userCurrentScore, BigDecimal userConsumeScore, Integer userPid, Integer userVipId, Date userDate, String userType, String userPassword, String userDeleteState, List<Account> accountList) {
        this.userId = userId;
        this.userName = userName;
        this.userWxImg = userWxImg;
        this.userWxName = userWxName;
        this.userTotalScore = userTotalScore;
        this.userCurrentScore = userCurrentScore;
        this.userConsumeScore = userConsumeScore;
        this.userPid = userPid;
        this.userVipId = userVipId;
        this.userDate = userDate;
        this.userType = userType;
        this.userPassword = userPassword;
        this.userDeleteState = userDeleteState;
        this.accountList = accountList;
    }

    public User() {
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserWxImg() {
        return userWxImg;
    }

    public void setUserWxImg(String userWxImg) {
        this.userWxImg = userWxImg;
    }

    public String getUserWxName() {
        return userWxName;
    }

    public void setUserWxName(String userWxName) {
        this.userWxName = userWxName;
    }

    public BigDecimal getUserTotalScore() {
        return userTotalScore;
    }

    public void setUserTotalScore(BigDecimal userTotalScore) {
        this.userTotalScore = userTotalScore;
    }

    public BigDecimal getUserCurrentScore() {
        return userCurrentScore;
    }

    public void setUserCurrentScore(BigDecimal userCurrentScore) {
        this.userCurrentScore = userCurrentScore;
    }

    public BigDecimal getUserConsumeScore() {
        return userConsumeScore;
    }

    public void setUserConsumeScore(BigDecimal userConsumeScore) {
        this.userConsumeScore = userConsumeScore;
    }

    public Integer getUserPid() {
        return userPid;
    }

    public void setUserPid(Integer userPid) {
        this.userPid = userPid;
    }

    public Integer getUserVipId() {
        return userVipId;
    }

    public void setUserVipId(Integer userVipId) {
        this.userVipId = userVipId;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDeleteState() {
        return userDeleteState;
    }

    public void setUserDeleteState(String userDeleteState) {
        this.userDeleteState = userDeleteState;
    }

}