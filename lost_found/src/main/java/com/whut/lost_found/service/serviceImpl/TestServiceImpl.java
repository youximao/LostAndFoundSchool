package com.whut.lost_found.service.serviceImpl;

import com.whut.lost_found.dao.TestUserRepertory;
import com.whut.lost_found.pojo.TestUser;
import com.whut.lost_found.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestUserRepertory testUserRepertory;

    @Override
    public List<TestUser> getAllUser() {
        return testUserRepertory.getAllUser();
    }
}
