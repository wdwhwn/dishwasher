package com.jingzhun.dao;

import com.jingzhun.entity.Cash;
import java.util.List;
/**
 * @author wd
 */
public interface CashDao {
    /*int deleteByPrimaryKey(Integer cashId);

    int insert(Cash record);

    Cash selectByPrimaryKey(Integer cashId);

    List<Cash> selectAll();

    int updateByPrimaryKey(Cash record);*/

    /**
     *查询当前用户的提现记录
     * @param userId  用户id
     * @return  L<list>
     */
    List<Cash> selectByCashRecord(Integer userId);

    /**
     * 添加提现记录
     * @param record  记录对象
     *
     */
    void insert(Cash record);
}