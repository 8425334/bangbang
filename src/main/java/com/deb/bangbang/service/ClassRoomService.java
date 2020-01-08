package com.deb.bangbang.service;

import com.deb.bangbang.bean.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    /**
     *  保存课室实体
     * @param room
     */
    void save(ClassRoom room);

    /**
     * 通过栋数查找
     * @param dong
     * @return
     */
    List<ClassRoom> findByDong(String dong, Integer status);

    List<ClassRoom> findByDongAndFloorAndStatus(String dong, String floor, Integer status);
}
