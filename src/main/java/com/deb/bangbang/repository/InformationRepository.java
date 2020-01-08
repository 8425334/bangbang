package com.deb.bangbang.repository;

import com.deb.bangbang.bean.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information, Integer> {
    List<Information> findByType(Integer type);
}
