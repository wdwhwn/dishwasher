package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private String token;

    private Date createTime;

    private Date updateTime;

    private Date effectiveTime;


}