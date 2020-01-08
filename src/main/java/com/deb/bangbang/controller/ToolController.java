package com.deb.bangbang.controller;

import com.deb.bangbang.bean.result.JsonResult;
import com.deb.bangbang.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolService toolService;

    /**
     * 获取所有的工具列表
     * @return
     */
    @GetMapping("/getToolList")
    public JsonResult getList(){
        try{
            return new JsonResult(200, toolService.findAll());
        }catch (Exception e){
            return new JsonResult(201, e.getMessage());
        }
    }
}
