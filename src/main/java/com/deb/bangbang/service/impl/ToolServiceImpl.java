package com.deb.bangbang.service.impl;

import com.deb.bangbang.bean.entity.Tool;
import com.deb.bangbang.repository.ToolRepository;
import com.deb.bangbang.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolRepository repository;

    /**
     * 保存对象实体
     *
     * @param tool
     */
    @Override
    public void save(Tool tool) {
        repository.save(tool);
    }

    /**
     * 通过类型查找
     *
     * @param type
     * @return
     */
    @Override
    public List<Tool> findByType(Integer type) {
        return repository.findByType(type);
    }

    @Override
    public List<Tool> findAll() {
        return repository.findAll();
    }
}
