package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class Account implements Serializable {
    private Integer accountId;

    private String accountType;
    private String accountAccountNumber;
    private String accountMobile;
    private String accountNameReal;

    private Integer accountUserId;

    private String accountDeleteState;



}