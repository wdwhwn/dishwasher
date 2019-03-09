package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsImg implements Serializable {
    private Integer goodsImgId;

    private String goodsImgImg;

    private Integer goodsImgGoodsId;

    private String goodsImgState;

    private String goodsImgType;


}