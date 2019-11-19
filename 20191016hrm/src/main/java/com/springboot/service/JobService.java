package com.springboot.service;

import com.springboot.bean.Dept;
import com.springboot.bean.Job;

import java.util.List;

public interface JobService {
    /*查询所有职位*/
    public List<Job> findJob();

    /*添加职位*/
    public void add(Job job);

    /*删除*/
    public void deleteById(Integer id);

    /*查询指定id的职位*/
    public Job selectById(Integer id);

    /*修改操作*/
    public void edit(Job job);

    /*返回json格式的字符串*/
    public String getAllJobJson();

}
