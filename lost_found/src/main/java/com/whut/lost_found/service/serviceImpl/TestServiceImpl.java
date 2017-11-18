package com.whut.lost_found.service.serviceImpl;

import com.whut.lost_found.dao.TestGoodsRepertory;
import com.whut.lost_found.dao.TestProcessRepertory;
import com.whut.lost_found.dao.TestUserRepertory;
import com.whut.lost_found.pojo.Goods;
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

    @Override
    public List<TestUser> getAllUser() {
        return testUserRepertory.getAllUser();
    }
    @Autowired
    TestUserRepertory testUserRepertory;

    @Autowired
    TestGoodsRepertory testGoodsRepertory;


    @Autowired
    TestProcessRepertory testProcessRepertory;

    @Override
    public List<Goods> getAllGoods() {
        return testGoodsRepertory.getAllGoods();
    }

    @Override
    public List<Process> getAllProcess() {
        return testProcessRepertory.getAllProcess();
    }

    @Override
    public List<Goods> getSortGoods(String ban) {
        return testGoodsRepertory.getSortGoods(ban);
    }


    @Override
    public  List<String> getType(){
        return testGoodsRepertory.getType();
    }

    @Override
    public List<Goods> getGoodsBySortAddress(String s, String j){
        return testGoodsRepertory.getGoodsBySortAddress(s,j);
    }

    @Override
    public List<Goods> getGoodsBySAD(String type, String lost,String date){
        return testGoodsRepertory.getGoodsBySAD(type,lost,date);
    }

    @Override
    public Goods getbyid(int s){
        return testGoodsRepertory.getbyid(s);
    };
    @Override
    public List<String>getLostAddress(){
        return testGoodsRepertory.getLostAddress();

    }


    @Override

    public List<String>getLostAddressBySort(String s){
        return testGoodsRepertory.getLostAddressBySort(s);
    }
    @Override

    public List<String> getDateBySortAddress(String type, String lost){

        return testGoodsRepertory.getDateBySortAddress(type,lost);


    }






}
