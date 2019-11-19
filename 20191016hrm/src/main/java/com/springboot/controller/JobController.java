package com.springboot.controller;

import com.springboot.bean.Dept;
import com.springboot.bean.Job;
import com.springboot.service.DeptService;
import com.springboot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class JobController {

    /*持有userservice对象*/
    @Autowired
    private JobService jobServiceImpl;

    /*查询职位*/
    @RequestMapping("/job/jobList")
    public String findUsers(Model model){
        List<Job> job = jobServiceImpl.findJob();
        model.addAttribute("jobs",job);
        return "/job/jobList";
    }

    /*跳转到添加页面*/
    @RequestMapping("/job/toAddJob")
    public String toaddUser(){
        return "/job/addJob";
    }
    /*添加用用户*/
    @RequestMapping("/job/addJob")
    public void addUser(Job job, HttpServletResponse response) throws IOException {
        jobServiceImpl.add(job);
        response.sendRedirect("/job/jobList");
    }

    /*删除页面*/
    @RequestMapping("/job/deleteJob")
    public void deleteById(Integer id, HttpServletResponse response) throws IOException {
        jobServiceImpl.deleteById(id);
        response.sendRedirect("/job/jobList");
    }

    /*跳转到编辑修改页面*/
    @RequestMapping("/job/toUpdateJob")
    public String edit(Integer id,Model model) {
        /*查询部门*/
        Job job = jobServiceImpl.selectById(id);
        model.addAttribute("job", job);
        return "job/updateJob";
    }

    /*修改操作*/
    @RequestMapping("/job/updateJob")
    public void edit(Job job,HttpServletResponse response) throws IOException{
        jobServiceImpl.edit(job);
        response.sendRedirect("/job/jobList");
    }

    /*返回json格式的字符串*/
    @RequestMapping("/job/loadJobAjax")
    @ResponseBody
    public String loadJobAjax(){
        return jobServiceImpl.getAllJobJson();
    }


}
