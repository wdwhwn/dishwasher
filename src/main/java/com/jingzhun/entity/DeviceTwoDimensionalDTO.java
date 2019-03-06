package com.jingzhun.entity;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
public class DeviceTwoDimensionalDTO {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "DeviceTwoDimensionalDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
