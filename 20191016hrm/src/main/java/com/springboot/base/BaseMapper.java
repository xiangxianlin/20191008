package com.springboot.base;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseMapper {
    /*添加用户*/
    public <T> void add(T entity);

    /*删除指定id用户*/
    public <T> void deleteById(Serializable id);

    /*修改指定id的用户*/
    public <T> void updateById(T entity);

    /*查询指定id的用户*/
    public <T> T getUser(Serializable id);

    /*查询总记录数*/
    public  int getCount(Map<String,Object> params);

    /*查询所有用户*/
    public <T> List<T> findUsers(Map<String,Object> params);

    /*查询所有用户并分页*/
    public <T> List<T> findByPage(Map<String,Object> params);


}
