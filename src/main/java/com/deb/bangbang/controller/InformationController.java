package com.deb.bangbang.controller;

import com.deb.bangbang.bean.result.JsonResult;
import com.deb.bangbang.constant.enums.CodeEnum;
import com.deb.bangbang.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/getAllInfo")
    public JsonResult getAllList(){
        return new JsonResult(CodeEnum.SUCCESS.getCode(), informationService.findAll());
    }

    @GetMapping("/getInfoByType")
    public JsonResult getInfoByType(@RequestParam("type") Integer type){
        return new JsonResult(CodeEnum.SUCCESS.getCode(), informationService.findByType(type));
    }
}