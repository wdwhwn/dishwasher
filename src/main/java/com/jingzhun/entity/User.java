package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private String userType;

    private String userPassword;

    private String userDeleteState;

    private String userWxOpenid;

    private String userMobile;
    private List<Account> accountList;

}