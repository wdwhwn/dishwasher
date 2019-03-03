package com.jingzhun.service;

import com.jingzhun.entity.ScoreItem;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */

public interface ScoreItemService {
    public List<ScoreItem> selectByScoreItem(Integer userId);
}
