package com.whut.lost_found.web;

import com.whut.lost_found.dao.TestGoodsRepertory;
import com.whut.lost_found.dao.TestUserRepertory;
import com.whut.lost_found.pojo.Goods;
import com.whut.lost_found.pojo.TestUser;
import com.whut.lost_found.pojo.User;
import com.whut.lost_found.service.TestService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Controller
@RequestMapping("/Test")
public class TestController {
     @Autowired
    TestService testService;

    @RequestMapping(value = "/getAllGoods") //传输物品信息至前端
    @ResponseBody
    public Object getGoodsArray(){
        JSONArray JsonArray = new JSONArray();
        for(Goods e:testService.getAllGoods()) {
            JSONObject Json = new JSONObject();
            Json.put("code", e.getLostaddress());//JSONObject对象中添加键值对
            Json.put("temple", e.getName());
            Json.put("text", e.getSort());
            String path=e.getPhotopath();
            String paths[]=path.split(";");
            Json.put("photo", paths[0]);
            JsonArray.add(Json);//将JSONObject对象添加到Json数组中
        }
        return JsonArray;
    }


    // 获取物品分类数组
    @RequestMapping("/getType")
    @ResponseBody
    public  Object getType(){
        return testService.getType();
    }

    //获取地址
    @RequestMapping("/getLostAddress")
    @ResponseBody
    public Object getLostaddress(){
        return testService.getLostAddress();
    }



    //通过分类获取地址
    @RequestMapping("/getLostAddressBySort")
    @ResponseBody
    public Object getLostAddredd(@RequestParam("sort")String sort){
        return testService.getLostAddressBySort(sort);
    }

    //通过分类、地点获取丢失日期
    @RequestMapping("/getDateBySortAddress")            //获取物品分类数组
    @ResponseBody
    public Object getDateBySortAddress(@RequestParam("sort")String sort,@RequestParam("address")String address) {

//        for(String s:testService.getDateBySortAddress(sort, address)){
//
//        }
//

        return testService.getDateBySortAddress(sort, address);

    }


        //通过分类返回查询结果
    @RequestMapping("/getSortGoods")
    @ResponseBody
    public Object getSortGoods(@RequestParam("sort")String sort){
        JSONArray JsonArray = new JSONArray();
        for(Goods e:testService.getSortGoods(sort)) {
            JSONObject Json = new JSONObject();
            Json.put("id",e.getId());
            Json.put("LostAddress", e.getLostaddress());//JSONObject对象中添加键值对
            Json.put("Name", e.getName());
            Json.put("Sort", e.getSort());
            //Json.put("PhotoPath", e.getPhotopath());
            String path=e.getPhotopath();
            String paths[]=path.split(";");
            Json.put("PhotoPath", paths[0]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//修改日期显示格式
            java.sql.Date date = e.getLostdate();
            java.util.Date d = new java.util.Date(date.getTime());
            String str = sdf.format(d);
            Json.put("LostDate", str);
            JsonArray.add(Json);//将JSONObject对象添加到Json数组中
        }
        return JsonArray;
    }

    //通过分类、地点返回查询结果
    @RequestMapping("/getGoodsBySortAndAddress")
    @ResponseBody
    public Object getGoods(@RequestParam("sort")String sort,@RequestParam("address")String address){
        JSONArray JsonArray = new JSONArray();
        for(Goods e:testService.getGoodsBySortAddress(sort,address)) {
            JSONObject Json = new JSONObject();
            Json.put("id",e.getId());
            Json.put("LostAddress", e.getLostaddress());//JSONObject对象中添加键值对
            Json.put("Name", e.getName());
            Json.put("Sort", e.getSort());
            String path=e.getPhotopath();
            String paths[]=path.split(";");
            Json.put("PhotoPath", paths[0]);
           // Json.put("PhotoPath", e.getPhotopath());
            java.sql.Date date=e.getLostdate();
            java.util.Date d=new java.util.Date (date.getTime());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
          //  System.out.println();
            Json.put("LostDate", simpleDateFormat.format(d));
            JsonArray.add(Json);//将JSONObject对象添加到Json数组中
        }
        return JsonArray;
    }


    //通过分类、地点、时间返回查询结果
    @RequestMapping("/getGoodsBySAD")
    @ResponseBody
    public Object getGoods(@RequestParam("sort")String sort,@RequestParam("address")String address,@RequestParam("date")String date){
        JSONArray JsonArray = new JSONArray();
        for(Goods e:testService.getGoodsBySAD(sort,address,date)) {
            JSONObject Json = new JSONObject();
            Json.put("id",e.getId());
            Json.put("LostAddress", e.getLostaddress());//JSONObject对象中添加键值对
            Json.put("Name", e.getName());
            Json.put("Sort", e.getSort());
            String path=e.getPhotopath();
            String paths[]=path.split(";");
            Json.put("PhotoPath", paths[0]);
           // Json.put("PhotoPath", e.getPhotopath());
            java.sql.Date datee=e.getLostdate();
            java.util.Date d=new java.util.Date (datee.getTime());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
            //  System.out.println();
            Json.put("LostDate", simpleDateFormat.format(d));
            JsonArray.add(Json);//将JSONObject对象添加到Json数组中
        }
        return JsonArray;
    }

    //通过ID查询单个物品信息
    @RequestMapping("/getGoodById")
    @ResponseBody
    public Object getGoods(@RequestParam("id")int id){

            JSONArray JsonArray = new JSONArray();
            JSONObject Json = new JSONObject();
            Json.put("d", testService.getbyid(id).getId());
            Json.put("LostAddress", testService.getbyid(id).getLostaddress());//JSONObject对象中添加键值对
            Json.put("Name", testService.getbyid(id).getName());
            Json.put("Sort", testService.getbyid(id).getSort());

            String path=testService.getbyid(id).getPhotopath();
            String paths[]=path.split(";");
            Json.put("PhotoPath", paths);
         // Json.put("PhotoPath", testService.getbyid(id).getPhotopath());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//修改日期显示格式
            java.sql.Date date=testService.getbyid(id).getLostdate();
            java.util.Date d=new java.util.Date (date.getTime());
            String str=sdf.format(d);
            Json.put("LostDate", str);
            JsonArray.add(Json);//将JSONObject对象添加到Json数组中
             return JsonArray;
    }

}
