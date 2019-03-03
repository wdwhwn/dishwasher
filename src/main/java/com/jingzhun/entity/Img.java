package com.jingzhun.entity;

import java.io.Serializable;

public class Img implements Serializable {
    private Integer imgId;

    private String imgImgUrl;

    private String imgDeleteState;

    private static final long serialVersionUID = 1L;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgImgUrl() {
        return imgImgUrl;
    }

    public void setImgImgUrl(String imgImgUrl) {
        this.imgImgUrl = imgImgUrl;
    }

    public String getImgDeleteState() {
        return imgDeleteState;
    }

    public void setImgDeleteState(String imgDeleteState) {
        this.imgDeleteState = imgDeleteState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", imgImgUrl=").append(imgImgUrl);
        sb.append(", imgDeleteState=").append(imgDeleteState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}