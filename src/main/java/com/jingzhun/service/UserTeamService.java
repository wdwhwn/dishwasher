package com.jingzhun.service;

import com.jingzhun.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
public interface UserTeamService {
    public List<User> selectByUserTeam(Integer userId);

}
