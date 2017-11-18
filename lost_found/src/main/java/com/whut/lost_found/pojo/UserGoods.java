package com.whut.lost_found.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Entity
@Table(name = "usergood")
public class UserGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "username")
    private String username;

    @Column(name="usertel")
    private String usertel;

    @Column(name="qrcode")
    private String qrcode;

    @Column(name = "goodid")
    private String goodid;



}