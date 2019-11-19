package com.springboot.controller;

import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    /*持有userservice对象*/
    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("finduser")
    public String findUser(){
        return "index";
    }

    /*访问main.jsp进入页面*/
    @RequestMapping("{page}")
    public String main(@PathVariable String page){
        return page;
    }

   /*查询所有用户*/
    @RequestMapping("/user/userList")
    public String findUsers(Model model){
        List<User> users = userServiceImpl.findUsers();
        model.addAttribute("users",users);
        return "/user/userList";
    }

    /*跳转到添加页面*/
    @RequestMapping("/user/toAddUser")
    public String toaddUser(){
        return "/user/addUser";
    }

    /*添加用用户*/
    @RequestMapping("/user/addUser")
    public void addUser(User user, HttpServletResponse response) throws IOException {
        userServiceImpl.addUser(user);
         response.sendRedirect("/user/userList");
    }

    /*修改用户状态*/
    @RequestMapping("/user/checkUser")
    public void addUser(Integer id, HttpServletResponse response) throws IOException {
        userServiceImpl.checkById(id);
        response.sendRedirect("/user/userList");
    }

    @RequestMapping("/user/deleteUser")
    public void deleteById(Integer id, HttpServletResponse response) throws IOException {
        userServiceImpl.deleteById(id);
        response.sendRedirect("/user/userList");
    }

    /*跳转到编辑修改页面*/
    @RequestMapping("/user/toUpdateUser")
    public String edit(Integer id,Model model) {
        /*查询用户*/
        User user = userServiceImpl.selectById(id);
        model.addAttribute("user",user);
        return "user/updateUser";
    }

    

 /*修改操作*/
    @RequestMapping("/user/updateUser")
    public void edit(User user,HttpServletResponse response) throws IOException{
        userServiceImpl.edit(user);
        response.sendRedirect("/user/userList");
    }

}
