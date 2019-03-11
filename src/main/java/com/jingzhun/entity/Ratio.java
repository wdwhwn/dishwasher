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
public class Ratio implements Serializable {
    private Integer ratioId;

    private String ratioRatio;

    private String ratioStatus;


}