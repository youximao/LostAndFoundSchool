package com.whut.lost_found.dao;

import com.whut.lost_found.pojo.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Administrator on 2017/7/23 0023.
 */
public interface TestUserRepertory extends JpaRepository<TestUser,String> {
    @Query(value = "select * from test",nativeQuery = true)
    public List<TestUser> getAllUser();

}
