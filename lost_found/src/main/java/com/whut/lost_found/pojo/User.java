package com.whut.lost_found.pojo;

/**
 * Created by Administrator on 2017/7/22 0022.
 */

public class User {
    int id;
    String name;
    String descri;

    public User(){
        super();
    }
    public User(int id,String name,String descri){
        this.id=id;
        this.name=name;
        this.descri=descri;
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
}
