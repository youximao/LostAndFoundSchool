package com.whut.lost_found.web;

import com.google.zxing.WriterException;
import com.whut.lost_found.Util.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

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

}
