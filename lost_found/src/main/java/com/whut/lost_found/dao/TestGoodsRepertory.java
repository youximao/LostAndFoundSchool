package com.whut.lost_found.dao;

import com.whut.lost_found.pojo.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/7/23 0023.
 */

public interface TestGoodsRepertory extends JpaRepository<Goods,String> {

    @Query(value = "select * from goods",nativeQuery = true)
    public List<Goods> getAllGoods();


    //获取分类
    @Query(value = "select distinct  sort  from goods ",nativeQuery = true)
    public List<String>getType();

    //获取地址
    @Query(value = "select distinct lostaddress from goods",nativeQuery = true)
    public List<String>getLostAddress();

    //通过分类获取丢失地点信息
    @Query(value = "select distinct lostaddress from goods where sort= ?1",nativeQuery = true)
    public List<String>getLostAddressBySort(String s);

    //通过分类、地点获取日期
    @Query(value = "select distinct lostdate from goods where sort=?1 AND lostaddress=?2 ",nativeQuery = true)
    public List<String> getDateBySortAddress(String type, String lost);

    @Query(value = "select distinct * from goods where name LIKE '%:can%'",nativeQuery = true)
    public List<Goods> getNameGoods(@Param("can") String name);

    //通过分类获取物品信息
    @Query(value = "select distinct * from goods where sort LIKE  ?1" ,nativeQuery = true)
    public List<Goods> getSortGoods(String name);


    //通过分类、地点获取物品信息
    @Query(value = "select distinct * from goods where sort=?1 AND lostaddress=?2 ",nativeQuery = true)
    public List<Goods> getGoodsBySortAddress(String type, String lost);

    //通过分类、地点、日期获取物品信息
    @Query(value = "select distinct * from goods where sort=?1 AND lostaddress=?2 AND lostdate=?3",nativeQuery = true)
    public List<Goods> getGoodsBySAD(String type, String lost,String date);

    //通过ID获取物品信息
    @Query(value = "select distinct *  from goods where id= ?1",nativeQuery = true)
    public Goods getbyid(int s);
//
//    @Query(value = "SELECT id ,name FROM gooods WHERE lostaddress = ?1")
//    public Page<Testgoods> findByLostaddress(String lostaddress, Pageable pageable);

}
