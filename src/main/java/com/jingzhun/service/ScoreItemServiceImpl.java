package com.jingzhun.service;

import com.jingzhun.dao.ScoreItemDao;
import com.jingzhun.entity.ScoreItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ScoreItemServiceImpl implements ScoreItemService {
    @Autowired
    private ScoreItemDao scoreItemDao;
    @Override
    public List<ScoreItem> selectByScoreItem(Integer userId) {
        List<ScoreItem> scoreItemList = scoreItemDao.selectByScoreItem(userId);
        return scoreItemList;
    }
}
