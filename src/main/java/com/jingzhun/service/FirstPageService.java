package com.jingzhun.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface FirstPageService {
    public Map<String,Object> selectByFistPage(Integer id,Integer page,Integer pageSize) throws Exception;
}
