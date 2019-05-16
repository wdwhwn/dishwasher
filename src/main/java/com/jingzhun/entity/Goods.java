package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class Goods implements Serializable {
    private Integer goodsId;

    private String goodsSn;

    private String goodsTitle;

    private BigDecimal goodsCurrnetScore;

    private BigDecimal goodsOriginScore;

    private String goodsServiceType;

    private String goodsBusiness;

    private String goodsDescribe;

    private String goodsDeleteState;

    private List<GoodsImg> goodsImgList;


}