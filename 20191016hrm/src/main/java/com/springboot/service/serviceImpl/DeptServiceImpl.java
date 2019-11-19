package com.springboot.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.bean.Dept;
import com.springboot.bean.Job;
import com.springboot.bean.User;
import com.springboot.mapper.DeptMapper;
import com.springboot.mapper.UserMapper;
import com.springboot.service.DeptService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {



    /*持有mapper对象*/
    @Autowired
    private DeptMapper deptMapper;


    /*c查询所有*/
    @Override
    public List<Dept> findDept() {

        return deptMapper.findUsers(null);
    }

//    /*添加用户*/
    @Override
    public void add(Dept dept) {
        deptMapper.add(dept);
   }
//
//    /*修改用户的状态*/
//    @Override
   /* public void checkById(Integer id) {
        deptMapper.check(id, 1);
    }*/
//
//    /*删除用户*/
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /*修改操作*/
    @Override
    public void edit(Dept dept) {
        deptMapper.updateById(dept);
    }
    /*查询指定id用户*/
    @Override
    public Dept selectById(Integer id) {
        return deptMapper.getUser(id);
    }
    /*返回json格式的字符串*/
    public String getAllJobJson(){
        List<Dept> depts = deptMapper.findUsers(null);
        /*定义json数组 [{key:value},{key2:value2}]*/
        JSONArray jsonArray=new JSONArray();
        /*遍历list集合*/
        for(Dept dept :depts){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",dept.getId());
            jsonObject.put("name",dept.getName());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }
}
