package com.whut.lost_found.pojo;

import sun.java2d.pipe.GeneralCompositePipe;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Entity
@Table(name = "user")
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @Column(name = "descript")
    String descript;

    @Column(name = "role")
    String role;



}
