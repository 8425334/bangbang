package com.deb.bangbang.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 课室
 */
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue()
    private Integer roomId;
    //课室状态
    private Integer status;
    //栋号
    private String dong;
    //教室号
    private String room;
    //层数
    private String floor;
    //负责人
    private String fzr;
    //课室情况描述(有问题的话)
    private String description;

    public ClassRoom() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFzr() {
        return fzr;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
