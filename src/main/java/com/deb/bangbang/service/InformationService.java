package com.deb.bangbang.service;

import com.deb.bangbang.bean.entity.Information;
import com.deb.bangbang.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface InformationService {

    void save(Information information);

    /**
     * 通过type类型查找
     * @param type
     * @return
     */
    List<Information> findByType(Integer type);

    /**
     * 查找全部
     * @return
     */
    List<Information> findAll();

}
