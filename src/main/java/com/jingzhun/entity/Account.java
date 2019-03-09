package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
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



}