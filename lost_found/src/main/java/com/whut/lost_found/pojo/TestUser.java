package com.whut.lost_found.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Entity
@Table(name = "test")
public class TestUser {
    @Id
    @Column(name = "Id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name="password")
    String password;

    @Column(name="descript")
    String descript;

    @Column(name = "role")
    String role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
