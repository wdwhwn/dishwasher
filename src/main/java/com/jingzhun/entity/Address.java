package com.jingzhun.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer addressId;

    private String addressName;

    private String addressPhone;

    private String addressDefaultState;

    private String addressAddress;

    private String addressDeleteState;

    private Integer addressUserId;

    private static final long serialVersionUID = 1L;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressDefaultState() {
        return addressDefaultState;
    }

    public void setAddressDefaultState(String addressDefaultState) {
        this.addressDefaultState = addressDefaultState;
    }

    public String getAddressAddress() {
        return addressAddress;
    }

    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
    }

    public String getAddressDeleteState() {
        return addressDeleteState;
    }

    public void setAddressDeleteState(String addressDeleteState) {
        this.addressDeleteState = addressDeleteState;
    }

    public Integer getAddressUserId() {
        return addressUserId;
    }

    public void setAddressUserId(Integer addressUserId) {
        this.addressUserId = addressUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", addressName=").append(addressName);
        sb.append(", addressPhone=").append(addressPhone);
        sb.append(", addressDefaultState=").append(addressDefaultState);
        sb.append(", addressAddress=").append(addressAddress);
        sb.append(", addressDeleteState=").append(addressDeleteState);
        sb.append(", addressUserId=").append(addressUserId);
        sb.append("]");
        return sb.toString();
    }
}