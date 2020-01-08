package com.deb.bangbang.service.impl;

import com.deb.bangbang.bean.entity.User;
import com.deb.bangbang.bean.vo.ScheduleTable;
import com.deb.bangbang.bean.vo.UserInfo;
import com.deb.bangbang.repository.ScheduleTableRepository;
import com.deb.bangbang.repository.UserInfoRepository;
import com.deb.bangbang.repository.UserRepository;
import com.deb.bangbang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository infoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleTableRepository tableRepository;
    /**
     * 储存用户信息
     *
     * @param info
     */
    @Override
    public void saveUserInfo(UserInfo info) {
        infoRepository.save(info);
    }

    /**
     * 储存用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * 储存课程安排表
     *
     * @param table
     */
    @Override
    public void saveScheduleTable(ScheduleTable table) {
        tableRepository.save(table);
    }

    /**
     * 通过openid找寻用户
     *
     * @param openid
     * @return
     */
    @Override
    public User findUserByOpenid(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
