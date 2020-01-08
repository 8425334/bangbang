package com.deb.bangbang.controller;

import com.deb.bangbang.bean.entity.ClassRoom;
import com.deb.bangbang.bean.result.JsonResult;
import com.deb.bangbang.constant.enums.CodeEnum;
import com.deb.bangbang.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;
    /**
     * 通过栋查找全部空余
     * @param dong
     * @return
     */
    @GetMapping("/{dong}/{status}")
    public JsonResult getDong(@PathVariable("dong") String dong,
                              @PathVariable("status") Integer status){
        return new JsonResult(CodeEnum.SUCCESS.getCode(), classRoomService.findByDong(dong, status));
    }
    /**
     * 通过栋查找全部空余
     * @param dong
     * @return
     */
    @GetMapping("/{dong}/{floor}/{status}")
    public JsonResult getDong(@PathVariable("dong") String dong,
                              @PathVariable("floor") String floor,
                              @PathVariable("status") Integer status){
        return new JsonResult(CodeEnum.SUCCESS.getCode(), classRoomService.findByDongAndFloorAndStatus(dong, floor, status));
    }

}
