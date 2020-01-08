package com.deb.bangbang.bean.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserInfo implements Serializable {

    //姓名
    private String name;
    //学号
    @Column(length = 13)
    private String stuId;
    //身份 老师 / 学生
    @Column(length = 1)
    private Integer identity;
    //头像
    private String headImage;

    private String createTime;

    @Id
    @GeneratedValue
    private Integer id;

    public UserInfo(String name, String stuId, Integer identity, String headImage) {
        this.name = name;
        this.stuId = stuId;
        this.identity = identity;
        this.headImage = headImage;
    }

    public UserInfo() {
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
