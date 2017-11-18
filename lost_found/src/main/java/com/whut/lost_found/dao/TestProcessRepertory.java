package com.whut.lost_found.dao;

import com.whut.lost_found.pojo.PProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Administrator on 2017/7/23 0023.
 */
public interface TestProcessRepertory extends JpaRepository<PProcess,String> {


    @Query(value = "select * from process",nativeQuery = true)
    public List<Process> getAllProcess();





}