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
public class GoodsImg implements Serializable {
    private Integer goodsImgId;

    private String goodsImgImg;

    private Integer goodsImgGoodsId;

    private String goodsImgState;

    private String goodsImgType;


}