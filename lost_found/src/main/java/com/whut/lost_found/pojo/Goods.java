package com.whut.lost_found.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @Column(name = "Id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "descri")
    String descri;
    @Column(name = "sort")
    String sort;
    @Column(name = "lostaddress")
    String lostaddress;
    @Column(name = "lostdate")
    Date lostdate;
    @Column(name = "losttime")
    Time losttime;
    @Column(name = "founddate")
    Date founddate;
    @Column(name = "foundtime")
    Time foundtime;
    @Column(name = "photopath")
    String photopath;

    @Column(name = "isfound")
    int isfound;

    public Goods() {
    }

    public Goods(int id, String name, String descri, String sort, String lostaddress, Date lostdate, Time losttime, Date founddate, Time foundtime, String photopath, int isfound) {
        this.id = id;
        this.name = name;
        this.descri = descri;
        this.sort = sort;
        this.lostaddress = lostaddress;
        this.lostdate = lostdate;
        this.losttime = losttime;
        this.founddate = founddate;
        this.foundtime = foundtime;
        this.photopath = photopath;
        this.isfound = isfound;
    }

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

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getLostaddress() {
        return lostaddress;
    }

    public void setLostaddress(String lostaddress) {
        this.lostaddress = lostaddress;
    }

    public Date getLostdate() {
        return lostdate;
    }

    public void setLostdate(Date lostdate) {
        this.lostdate = lostdate;
    }

    public Time getLosttime() {
        return losttime;
    }

    public void setLosttime(Time losttime) {
        this.losttime = losttime;
    }

    public Date getFounddate() {
        return founddate;
    }

    public void setFounddate(Date founddate) {
        this.founddate = founddate;
    }

    public Time getFoundtime() {
        return foundtime;
    }

    public void setFoundtime(Time foundtime) {
        this.foundtime = foundtime;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public int getIsfound() {
        return isfound;
    }

    public void setIsfound(int isfound) {
        this.isfound = isfound;
    }
}


