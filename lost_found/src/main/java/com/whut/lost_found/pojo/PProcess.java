package com.whut.lost_found.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.*;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Entity
@Table(name = "pprocess")
public class PProcess {
    @Id
    @Column(name = "Id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "phonenumber")
    String phonenumber;

    @Column(name = "qr_code")
    String qr_code;

    @Column(name = "isget")
    int isget;

    @Column(name = "getdate")
    Date getdate;

    @Column(name = "gettime")
    Time gettime;
    @Column(name = "isverify")
    int isverify;

    @Column(name = "verifydate")
    Date verifydate;
    @Column(name = "verifytime")
    Time verifytime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public int getIsget() {
        return isget;
    }

    public void setIsget(int isget) {
        this.isget = isget;
    }

    public Date getGetdate() {
        return getdate;
    }

    public void setGetdate(Date getdate) {
        this.getdate = getdate;
    }

    public Time getGettime() {
        return gettime;
    }

    public void setGettime(Time gettime) {
        this.gettime = gettime;
    }

    public int getIsverify() {
        return isverify;
    }

    public void setIsverify(int isverify) {
        this.isverify = isverify;
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
    }

    public Time getVerifytime() {
        return verifytime;
    }

    public void setVerifytime(Time verifytime) {
        this.verifytime = verifytime;
    }
}