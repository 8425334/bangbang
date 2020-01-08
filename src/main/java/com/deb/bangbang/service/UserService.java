package com.deb.bangbang.service;

import com.deb.bangbang.bean.entity.User;
import com.deb.bangbang.bean.vo.ScheduleTable;
import com.deb.bangbang.bean.vo.UserInfo;


public interface UserService {

    /**
     * 储存用户信息
     * @param info
     */
    void saveUserInfo(UserInfo info);

    /**
     * 储存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 储存课程安排表
     * @param table
     */
    void saveScheduleTable(ScheduleTable table);

    /**
     * 通过openid找寻用户
     * @param openid
     * @return
     */
    User findUserByOpenid(String openid);
}
