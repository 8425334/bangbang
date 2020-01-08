package com.deb.bangbang.bean.vo;

import com.deb.bangbang.bean.entity.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 课表
 */
@Entity
public class ScheduleTable implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public ScheduleTable() {

    }
}
