package com.deb.bangbang.service;

import com.deb.bangbang.bean.entity.Tool;

import java.util.List;

/**
 * 工具服务接口
 */
public interface ToolService {
    /**
     * 保存对象实体
     * @param tool
     */
    void save(Tool tool);

    /**
     * 通过类型查找
     * @param type
     * @return
     */
    List<Tool> findByType(Integer type);

    List<Tool> findAll();
}
