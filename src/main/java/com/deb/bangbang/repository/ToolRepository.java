package com.deb.bangbang.repository;

import com.deb.bangbang.bean.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
    /**
     *  通过type查找
     * @param type
     * @return
     */
    List<Tool> findByType(Integer type);
}
