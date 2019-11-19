package com.springboot.service;

import com.springboot.bean.Notice;

import java.util.List;

public interface NoticeService {
    /*查询所有的公告*/
    public List<Notice> findNotice();

    /*根据标题模糊查询*/
    public List<Notice> findNoticeByTitle(String title);

    /*添加公告的功能*/
    public void add(Notice notice);

    /*删除公告的功能*/
    public void delete(Integer id);

    /*查询指定id的公告*/
    public Notice findById(Integer id);

    /*修改公告操作*/
    public void update(Notice notice);


}
