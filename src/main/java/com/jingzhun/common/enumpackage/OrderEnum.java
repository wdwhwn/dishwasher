package com.jingzhun.common.enumpackage;

/**
 * Created by Administrator on 2019/3/8 0008.
 */
public enum OrderEnum {
    Success("订单提交成功"),Fail("积分余额不足");
    private String name;
    OrderEnum(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
