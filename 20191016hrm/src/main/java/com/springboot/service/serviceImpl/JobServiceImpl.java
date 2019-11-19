package com.springboot.service.serviceImpl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.bean.Job;
import com.springboot.mapper.DeptMapper;
import com.springboot.mapper.JobMapper;
import com.springboot.service.DeptService;
import com.springboot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {



    /*持有mapper对象*/
    @Autowired
    private JobMapper jobMapper;


    /*c查询所有*/
    @Override
    public List<Job> findJob() {

        return jobMapper.findUsers(null);
    }

    /*添加职位*/
    public void add(Job job){
        jobMapper.add(job);
    }

    /*删除*/
    public void deleteById(Integer id){
        jobMapper.deleteById(id);
    }

    /*查询指定id的职位*/
    public Job selectById(Integer id){
        return jobMapper.getUser(id);
    }

    /*修改操作*/
    public void edit(Job job){
        jobMapper.updateById(job);
    }


    /*返回json格式的字符串*/
    public String getAllJobJson(){
        List<Job> jobs = jobMapper.findUsers(null);
        /*定义json数组 [{key:value},{key2:value2}]*/
        JSONArray jsonArray=new JSONArray();
        /*遍历list集合*/
        for(Job job:jobs){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",job.getId());
            jsonObject.put("name",job.getName());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }
}
