package com.jingzhun.dao;

import com.jingzhun.entity.ScoreItem;
import java.util.List;
/**
 * @author wd
 */
public interface ScoreItemDao {
  /*  int deleteByPrimaryKey(Integer scoreItemId);



    ScoreItem selectByPrimaryKey(Integer scoreItemId);

    List<ScoreItem> selectAll();

    int updateByPrimaryKey(ScoreItem record);*/

    /**
     *  添加积分明细记录
     * @param record
     * @return
     */
    int insert(ScoreItem record);

    /**
     *   积分明细
     * @param userId
     * @return  List<ScoreItem>
     */
    List<ScoreItem> selectByScoreItem(Integer userId);
}