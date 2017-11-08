package com.whut.lost_found.web;

import com.google.zxing.WriterException;
import com.whut.lost_found.Util.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Controller
@RequestMapping("/qr")
public class QrcodeCon {

    QRCodeUtil qrCodeUtil;

    @RequestMapping("/getqrajax")
    public String getQrAjax(){
        return "Qrcode";
    }

    @RequestMapping("/testjscss")
    public String getJsCss(){
        return "TestJs";
    }

    @RequestMapping("/getone")
    public void getOne(HttpServletResponse response){
        try {
            BufferedImage bufferedImage= qrCodeUtil.toBufferedImage("http://www.maoxiaomiyy.com",500,500);
            ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return new String("df");
    }

    @RequestMapping("/getflush")
    public void getFLush(HttpServletResponse response) throws IOException {


        try {
            File file=new File("Image 2017-11-07_16-51-27.png");
            FileInputStream fileInputStream=new FileInputStream(file);
            byte []bytes=new byte[1024];
            while (fileInputStream.read(bytes)!=-1) {
                response.getOutputStream().write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //OutputStream outputStream=new ObjectOutputStream(file);

    }

    @RequestMapping("/yanzhengCode")
    public void getYanZhengCode(HttpServletResponse response){
        BufferedImage bi=new BufferedImage(68,22,BufferedImage.TYPE_INT_BGR);
        Graphics g=bi.getGraphics();
        Color c=new Color(250,150,255);
        g.setColor(c);
        g.fillRect(0,0,68,22);
        //验证码字符集合
        char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r=new Random();
        int len=ch.length;
        int index;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;++i){
            index=r.nextInt(len);
            //设置验证码字符随机颜色
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            //画出对应随机的验证码字符
            g.drawString(ch[index]+"",(i*15)+3,18);
            sb.append(ch[index]);
        }
        try {
            ImageIO.write(bi,"GIF",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
