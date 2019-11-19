package com.springboot.service;

import com.springboot.bean.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    /*查询所有用户*/
    public List<User> findUsers();


    /*添加用户*/
    public void addUser(User user);

    /*修改用户的状态*/
    public void checkById(Integer id);

    /*删除用户*/
    public void deleteById(Integer id);

    /*修改操作*/
    public void edit(User user);

    /*查询指定id的用户*/
    public User selectById(Integer id);

}
