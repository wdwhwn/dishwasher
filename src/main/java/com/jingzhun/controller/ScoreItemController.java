package com.jingzhun.controller;

import com.jingzhun.entity.ScoreItem;
import com.jingzhun.service.ScoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class ScoreItemController {
    @Autowired
    private ScoreItemService scoreItemService;
    @RequestMapping("/selectByScoreItem")
    @ResponseBody
    public List<ScoreItem> selectByScoreItem(Integer userId){
        List<ScoreItem> scoreItemList = scoreItemService.selectByScoreItem(userId);
        return scoreItemList;
    }
}
