package com.springboot.mapper;

import com.springboot.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper 数据访问类
 * @author qxy
 * @email qxy@163.com
 * @date 2019-10-16 11:15:57
 * @version 1.0
 */

@Mapper
/*去继承基本的接口*/
public interface UserMapper  extends BaseMapper {


    /*@param参数传递*/
    public void check(@Param("id") int id, @Param("status") int status);
}