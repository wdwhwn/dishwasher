package com.jingzhun.controller;

import com.jingzhun.entity.ScoreItem;
import com.jingzhun.service.ScoreItemService;
import com.jingzhun.utils.jsonutil.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王丹
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ScoreItemController {
    @Autowired
    private ScoreItemService scoreItemService;
    @RequestMapping("/selectByScoreItem")
    public String selectByScoreItem(Integer userId){
        List<ScoreItem> scoreItemList = scoreItemService.selectByScoreItem(userId);
        return JsonUtil.toJson(scoreItemList);
    }
}
