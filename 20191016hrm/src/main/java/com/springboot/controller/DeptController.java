package com.springboot.controller;

import com.springboot.bean.Dept;
import com.springboot.bean.User;
import com.springboot.service.DeptService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class DeptController {

    /*持有userservice对象*/
    @Autowired
    private DeptService deptServiceImpl;

/*    @RequestMapping("finduser")
    public String findUser(){
        return "index";
    }*/

//    //访问main.jsp进入页面
//    @RequestMapping("{page}")
//    public String main(@PathVariable String page){
//        return page;
//    }


    /*查询所有部门*/
    @RequestMapping("/dept/deptList")
    public String findUsers(Model model){

        List<Dept> depts = deptServiceImpl.findDept();
        model.addAttribute("depts",depts);
        return "/dept/deptList";
    }



    /*跳转到添加页面*/
    @RequestMapping("/dept/toAddDept")
    public String toaddUser(){
        return "/dept/addDept";
    }

    /*添加用用户*/
    @RequestMapping("/dept/addDept")
    public void addUser(Dept dept, HttpServletResponse response) throws IOException {
        deptServiceImpl.add(dept);
        response.sendRedirect("/dept/deptList");
    }


/*删除页面*/
    @RequestMapping("/dept/deleteDept")
    public void deleteById(Integer id, HttpServletResponse response) throws IOException {
        deptServiceImpl.deleteById(id);
        response.sendRedirect("/dept/deptList");
    }

   /*跳转到编辑修改页面*/
    @RequestMapping("/dept/toUpdateDept")
    public String edit(Integer id,Model model) {
        /*查询部门*/
         Dept dept=deptServiceImpl.selectById(id);
        model.addAttribute("dept",dept);
        return "dept/updateDept";
    }



    /*修改操作*/
    @RequestMapping("/dept/updateDept")
    public void edit(Dept dept,HttpServletResponse response) throws IOException{
        deptServiceImpl.edit(dept);
        response.sendRedirect("/dept/deptList");
    }

    /*返回json格式的字符串*/
    @RequestMapping("/dept/loadDeptAjax")
    @ResponseBody
    public String loadJobAjax(){
        return deptServiceImpl.getAllJobJson();
    }
}
