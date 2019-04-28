package com.jingzhun.entity.weixin;

/**
 * Created by Administrator on 2019/4/23 0023.
 */
public class WeixinShare {
    private String noncestr;
    private Long timestamp;
    private String signature;

    public WeixinShare() {
    }

    public WeixinShare(String noncestr, Long timestamp, String signature) {
        this.noncestr = noncestr;
        this.timestamp = timestamp;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "WeixinShare{" +
                "noncestr='" + noncestr + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
