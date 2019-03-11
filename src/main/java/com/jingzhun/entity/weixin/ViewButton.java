package com.jingzhun.entity.weixin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/3/11 0011.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @author wd
 */
public class ViewButton extends Button {
    private String url;
}
