package com.deb.bangbang.repository;

import com.deb.bangbang.bean.entity.ClassRoom;
import com.deb.bangbang.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer>{

    List<ClassRoom> findByDongAndFloorAndStatus(String dong, String floor, Integer status);
    List<ClassRoom> findByDongAndStatus(String dong, Integer status);


}
