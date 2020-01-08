package com.deb.bangbang.bean.entity;

import com.deb.bangbang.bean.vo.ScheduleTable;
import com.deb.bangbang.bean.vo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    //WeChat OpenId
    @NotNull
    @Column(name = "openid")
    private String openid = "test";

    @Id
    @GeneratedValue
    private Integer id;

    //用户信息
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private UserInfo userInfo;

    //课程信息
    @JoinColumn(name="sid")
    @OneToOne(cascade = CascadeType.ALL)
    private ScheduleTable scheduleTable;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(UserInfo userInfo, ScheduleTable scheduleTable) {
        this.userInfo = userInfo;
        this.scheduleTable = scheduleTable;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ScheduleTable getScheduleTable() {
        return scheduleTable;
    }

    public void setScheduleTable(ScheduleTable scheduleTable) {
        this.scheduleTable = scheduleTable;
    }
}
