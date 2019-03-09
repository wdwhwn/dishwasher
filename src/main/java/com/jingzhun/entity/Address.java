package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private Integer addressId;

    private String addressName;

    private String addressPhone;

    private String addressDefaultState;

    private String addressAddress;

    private String addressDeleteState;

    private Integer addressUserId;

    private static final long serialVersionUID = 1L;


}