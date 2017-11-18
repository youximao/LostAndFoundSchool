package com.whut.lost_found.service;

import com.whut.lost_found.pojo.Goods;
import com.whut.lost_found.pojo.TestUser;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public interface TestService {

    public List<TestUser> getAllUser();
    public List<Goods> getAllGoods();
    public List<Process> getAllProcess();
    public List<Goods> getSortGoods(String ban);

    public  List<String> getType();
    public List<Goods> getGoodsBySortAddress(String s, String j);
    public List<Goods> getGoodsBySAD(String type, String lost,String date);


    public List<String>getLostAddressBySort(String s);
    public List<String>getLostAddress();
    public List<String> getDateBySortAddress(String type, String lost);




    public Goods getbyid(int s);
}
