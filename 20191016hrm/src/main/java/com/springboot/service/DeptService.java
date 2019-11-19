package com.springboot.service;

import com.springboot.bean.Dept;


import java.util.List;

public interface DeptService {
    /*查询所有部门*/
    public List<Dept> findDept();


   /* *//*添加部门*/
    public void add(Dept dept);



    /*删除*/
    public void deleteById(Integer id);

    /*修改操作*/
    public void edit(Dept dept);

    /*查询指定id的部门*/
    public Dept selectById(Integer id);

    /*返回json格式的字符串*/
    public String getAllJobJson();
}
