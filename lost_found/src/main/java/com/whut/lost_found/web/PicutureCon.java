package com.whut.lost_found.web;

import org.springframework.stereotype.Controller;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/5 0005.
 */
@Controller
@RequestMapping("/pic")
public class PicutureCon {

    @RequestMapping("/updatehtml")
    public String getUpdateHtml(){
        return "picup";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestParam("file") MultipartFile file){

        Map<String,String> map=new HashMap<String,String>();
        if(!file.isEmpty()){
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
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
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
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
