package com.jingzhun.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsImg implements Serializable {
    private Integer goodsImgId;

    private String goodsImgImg;

    private Integer goodsImgGoodsId;

    private String goodsImgState;

    private String goodsImgType;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsImgId() {
        return goodsImgId;
    }

    public void setGoodsImgId(Integer goodsImgId) {
        this.goodsImgId = goodsImgId;
    }

    public String getGoodsImgImg() {
        return goodsImgImg;
    }

    public void setGoodsImgImg(String goodsImgImg) {
        this.goodsImgImg = goodsImgImg;
    }

    public Integer getGoodsImgGoodsId() {
        return goodsImgGoodsId;
    }

    public void setGoodsImgGoodsId(Integer goodsImgGoodsId) {
        this.goodsImgGoodsId = goodsImgGoodsId;
    }

    public String getGoodsImgState() {
        return goodsImgState;
    }

    public void setGoodsImgState(String goodsImgState) {
        this.goodsImgState = goodsImgState;
    }

    public String getGoodsImgType() {
        return goodsImgType;
    }

    public void setGoodsImgType(String goodsImgType) {
        this.goodsImgType = goodsImgType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsImgId=").append(goodsImgId);
        sb.append(", goodsImgImg=").append(goodsImgImg);
        sb.append(", goodsImgGoodsId=").append(goodsImgGoodsId);
        sb.append(", goodsImgState=").append(goodsImgState);
        sb.append(", goodsImgType=").append(goodsImgType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}