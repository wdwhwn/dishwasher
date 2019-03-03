package com.jingzhun.dao;

import com.jingzhun.entity.ScoreItem;
import java.util.List;

public interface ScoreItemDao {
    int deleteByPrimaryKey(Integer scoreItemId);

    int insert(ScoreItem record);

    ScoreItem selectByPrimaryKey(Integer scoreItemId);

    List<ScoreItem> selectAll();

    int updateByPrimaryKey(ScoreItem record);

//    积分明细
    List<ScoreItem> selectByScoreItem(Integer userId);
}