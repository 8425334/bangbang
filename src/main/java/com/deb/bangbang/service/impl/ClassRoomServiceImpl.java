package com.deb.bangbang.service.impl;

import com.deb.bangbang.bean.entity.ClassRoom;
import com.deb.bangbang.repository.ClassRoomRepository;
import com.deb.bangbang.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    /**
     * 保存课室实体
     *
     * @param room
     */
    @Override
    public void save(ClassRoom room) {
        classRoomRepository.save(room);
    }

    /**
     * 通过栋数查找
     *
     * @param dong
     * @return
     */
    @Override
    public List<ClassRoom> findByDong(String dong, Integer status) {
        return classRoomRepository.findByDongAndStatus(dong, status);
    }

    @Override
    public List<ClassRoom> findByDongAndFloorAndStatus(String dong, String floor, Integer status) {
        return classRoomRepository.findByDongAndFloorAndStatus(dong, floor, status);
    }
}
