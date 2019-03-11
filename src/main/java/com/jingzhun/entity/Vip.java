package com.jingzhun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class Vip implements Serializable {
    private Integer vipId;

    private String vipType;

    private BigDecimal vipScore;

    private Integer vipTerm;


}