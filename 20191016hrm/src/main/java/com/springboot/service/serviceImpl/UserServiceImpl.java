package com.springboot.service.serviceImpl;

import com.springboot.bean.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    /*持有mapper对象*/
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findUsers() {

        return userMapper.findUsers(null);
    }

    /*添加用户*/
    @Override
    public void addUser(User user) {
        userMapper.add(user);
    }

    /*修改用户的状态*/
    @Override
    public void checkById(Integer id) {
        userMapper.check(id, 1);
    }

    /*删除用户*/
    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    /*修改操作*/
    @Override
    public void edit(User user) {
        userMapper.updateById(user);
    }
    /*查询指定id用户*/
    @Override
    public User selectById(Integer id) {
        return userMapper.getUser(id);
    }
}
