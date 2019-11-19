package com.springboot.service.serviceImpl;

import com.springboot.bean.Notice;
import com.springboot.mapper.NoticeMapper;
import com.springboot.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

     @Autowired
     NoticeMapper noticeMapper;

    @Override
    /*查询所有的公告*/
    public List<Notice> findNotice() {
        return noticeMapper.findUsers(null);
    }

    /*根据标题模糊查询*/
    @Override
    public List<Notice> findNoticeByTitle(String title){
        Map<String,Object> map=new HashMap<String, Object>();
        /*判断标题是否为空*/
        if(StringUtils.isNotEmpty(title)){
          map.put("title","%"+title+"%");
        }

        return noticeMapper.findUsers(map);
    }

    /*添加公告的功能*/
    public void add(Notice notice){
        /*设置创建日期*/
        notice.setCreateDate(new Date());
        /*设置添加公告人的id这里默认给值1*/
        notice.setUserId(1);
        noticeMapper.add(notice);
    }

    /*删除公告的功能*/
    public void delete(Integer id){
        noticeMapper.deleteById(id);
    }

    /*查询指定id的公告*/
    public Notice findById(Integer id){
        return noticeMapper.getUser(id);
    }

    /*修改公告操作*/
    public void update(Notice notice){
        noticeMapper.updateById(notice);
    }
}
