package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Goods implements Serializable {
    private Integer goodsId;

    private String goodsTitle;

    private BigDecimal goodsCurrnetScore;

    private BigDecimal goodsOriginScore;

    private String goodsServiceType;

    private String goodsBusiness;

    private String goodsDescribe;

    private String goodsDeleteState;

    private List<GoodsImg> goodsImgList;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsCurrnetScore=" + goodsCurrnetScore +
                ", goodsOriginScore=" + goodsOriginScore +
                ", goodsServiceType='" + goodsServiceType + '\'' +
                ", goodsBusiness='" + goodsBusiness + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsDeleteState='" + goodsDeleteState + '\'' +
                ", goodsImgList=" + goodsImgList +
                '}';
    }

    public List<GoodsImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<GoodsImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public Goods(Integer goodsId, String goodsTitle, BigDecimal goodsCurrnetScore, BigDecimal goodsOriginScore, String goodsServiceType, String goodsBusiness, String goodsDescribe, String goodsDeleteState, List<GoodsImg> goodsImgList) {
        this.goodsId = goodsId;
        this.goodsTitle = goodsTitle;
        this.goodsCurrnetScore = goodsCurrnetScore;
        this.goodsOriginScore = goodsOriginScore;
        this.goodsServiceType = goodsServiceType;
        this.goodsBusiness = goodsBusiness;
        this.goodsDescribe = goodsDescribe;
        this.goodsDeleteState = goodsDeleteState;
        this.goodsImgList = goodsImgList;
    }

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public BigDecimal getGoodsCurrnetScore() {
        return goodsCurrnetScore;
    }

    public void setGoodsCurrnetScore(BigDecimal goodsCurrnetScore) {
        this.goodsCurrnetScore = goodsCurrnetScore;
    }

    public BigDecimal getGoodsOriginScore() {
        return goodsOriginScore;
    }

    public void setGoodsOriginScore(BigDecimal goodsOriginScore) {
        this.goodsOriginScore = goodsOriginScore;
    }

    public String getGoodsServiceType() {
        return goodsServiceType;
    }

    public void setGoodsServiceType(String goodsServiceType) {
        this.goodsServiceType = goodsServiceType;
    }

    public String getGoodsBusiness() {
        return goodsBusiness;
    }

    public void setGoodsBusiness(String goodsBusiness) {
        this.goodsBusiness = goodsBusiness;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsDeleteState() {
        return goodsDeleteState;
    }

    public void setGoodsDeleteState(String goodsDeleteState) {
        this.goodsDeleteState = goodsDeleteState;
    }

    public Goods() {
    }
}