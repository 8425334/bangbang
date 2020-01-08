package com.deb.bangbang.repository;

import com.deb.bangbang.bean.vo.ScheduleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTableRepository extends JpaRepository<ScheduleTable, Integer> {

}
