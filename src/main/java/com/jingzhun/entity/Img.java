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
public class Img implements Serializable {
    private Integer imgId;

    private String imgImgUrl;

    private String imgDeleteState;


}