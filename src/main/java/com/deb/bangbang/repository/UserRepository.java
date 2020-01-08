package com.deb.bangbang.repository;

import com.deb.bangbang.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByOpenid(String openid);
}