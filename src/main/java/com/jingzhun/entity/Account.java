package com.jingzhun.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer accountId;

    private String accountType;
//1
    private String accountAccountNumber;
//  1
    private String accountMobile;
//1
    private String accountNameReal;

    private Integer accountUserId;

    private String accountDeleteState;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", accountAccountNumber='" + accountAccountNumber + '\'' +
                ", accountMobile='" + accountMobile + '\'' +
                ", accountNameReal='" + accountNameReal + '\'' +
                ", accountUserId=" + accountUserId +
                ", accountDeleteState='" + accountDeleteState + '\'' +
                '}';
    }

    public String getAccountAccountNumber() {
        return accountAccountNumber;
    }

    public void setAccountAccountNumber(String accountAccountNumber) {
        this.accountAccountNumber = accountAccountNumber;
    }

    public String getAccountMobile() {
        return accountMobile;
    }

    public void setAccountMobile(String accountMobile) {
        this.accountMobile = accountMobile;
    }

    public String getAccountNameReal() {
        return accountNameReal;
    }

    public void setAccountNameReal(String accountNameReal) {
        this.accountNameReal = accountNameReal;
    }

    private static final long serialVersionUID = 1L;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(Integer accountUserId) {
        this.accountUserId = accountUserId;
    }

    public String getAccountDeleteState() {
        return accountDeleteState;
    }

    public void setAccountDeleteState(String accountDeleteState) {
        this.accountDeleteState = accountDeleteState;
    }

}