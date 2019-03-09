package com.jingzhun.entity;

public enum  ConstantFile {
    USA("美国",1),CHINA("中国",2);
    private String name;
    private int index;
    private ConstantFile(String name,int index){
        this.name=name;
        this.index=index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
