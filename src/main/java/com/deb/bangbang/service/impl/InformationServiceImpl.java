package com.deb.bangbang.service.impl;

import com.deb.bangbang.bean.entity.Information;
import com.deb.bangbang.repository.InformationRepository;
import com.deb.bangbang.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationRepository repository;

    @Override
    public void save(Information information) {
        repository.save(information);
    }

    /**
     * 通过type类型查找
     *
     * @param type
     * @return
     */
    @Override
    public List<Information> findByType(Integer type) {
        return repository.findByType(type);
    }

    /**
     * 查找全部
     *
     * @return
     */
    @Override
    public List<Information> findAll() {
        return repository.findAll();
    }
}
