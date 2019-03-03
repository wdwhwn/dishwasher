package com.jingzhun.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer accountId;

    private String accountType;

    private String accountNumber;

    private Integer accountUserId;

    private String accountDeleteState;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", accountType=").append(accountType);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", accountUserId=").append(accountUserId);
        sb.append(", accountDeleteState=").append(accountDeleteState);
        sb.append("]");
        return sb.toString();
    }
}