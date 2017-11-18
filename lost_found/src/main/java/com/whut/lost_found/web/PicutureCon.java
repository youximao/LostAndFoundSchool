package com.whut.lost_found.web;

import com.whut.lost_found.dao.TestGoodsRepertory;
import com.whut.lost_found.pojo.Goods;
import com.whut.lost_found.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/5 0005.
 */
@Controller
@RequestMapping("/pic")
public class PicutureCon {

    @Autowired
    TestGoodsRepertory testGoodsRepertory;

    @RequestMapping("/updatehtml")
    public String getUpdateHtml(){
        return "picup";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestParam("file") MultipartFile file,HttpServletRequest request){




            //HttpServletRequest req
            //  req.getSession().;

        Map<String,String> map=new HashMap<String,String>();
        if(!file.isEmpty()){
            try {
                File f=new File("./src/main/resources/static/images/"+file.getOriginalFilename());
                BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream(f));

                Goods good=new Goods();
                //  good.setId(Integer.valueOf(request.getParameter("id")));
                good.setId(222);
                good.setDescri("cheshi");
                good.setFounddate(new Date(2017-11-7));
                // good.setFoundtime((new Time(2:11:02));
                good.setPhotopath("/images/"+f.getAbsoluteFile());
                testGoodsRepertory.save(good);

//                System.out.println(f);
//                System.out.println(f.toPath());
//                System.out.println(f.getName());
//                System.out.println(f.getAbsoluteFile());
//               System.out.println(f.getPath());
                out.write(file.getBytes());
                out.flush();
                out.close();
            }catch (Exception e){
                 map.put("result",e.toString());

            }

        }else map.put("result","file is empty");

         if(!map.containsKey("result"))map.put("result","ok");

        return map;
    }


    @RequestMapping(value = "/updatebatch", method = RequestMethod.POST)
    @ResponseBody
    public Object batchUpload(HttpServletRequest request) {

        Map<String,String> map=new HashMap<String,String>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));//加地址
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    map.put("result","You failed to upload " + i + " => " + e.getMessage());
                }
            } else {
                map.put("result", "You failed to upload " + i + " because the file was empty.");
            }
        }
        if(!map.containsKey("result"))map.put("result","ok");
        return map;
    }


}
