package com.springboot.controller;

import com.springboot.bean.Notice;
import com.springboot.service.NoticeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /*跳转到添加页面*/
    @RequestMapping("/notice/toAddNotice")
    public String toAddNotice(){
      return "notice/addNotice";
    }

    /*添加公告的功能*/
    @RequestMapping("notice/addNotice")
    public String addNotice(Notice notice){
        noticeService.add(notice);
        return "redirect:/notice/noticeList";
    }


    /*查询所有公告将数据封装并传输到前端页面*/
    @RequestMapping("/notice/noticeList")
    public String toNoticeList(Model model){
        List<Notice> notices = noticeService.findNotice();
        model.addAttribute("notices",notices);
        return "notice/noticeList";
    }

    /*模糊查询*/
    @RequestMapping("/notice/selectNotice")
    public String NoticeList(Model model,String title){
        List<Notice> notices = noticeService.findNoticeByTitle(title);
        model.addAttribute("notices",notices);
        return "notice/noticeList";
    }

    /*删除指定id的公告*/
    @RequestMapping("notice/deleteNotice")
    public String delete(Integer id){
        noticeService.delete(id);
        return "redirect:/notice/noticeList";
    }

    /*查询指定id的公告跳转到修改页面*/
    @RequestMapping("/notice/toUpdateNotice")
    public String update(Integer id,Model model){
        /*查询指定id的公告*/
        Notice notice=noticeService.findById(id);
        model.addAttribute("notice",notice);
       return "/notice/updateNotice";
    }

    /*修改操作*/
    @RequestMapping("/notice/updateNotice")
    public String delete(Notice notice){
        noticeService.update(notice);
        return "redirect:/notice/noticeList";
    }

    /*预览功能*/
    @RequestMapping("notice/prevNotice")
    public String prevNotice(Integer id, Model model){
        /*查询指定id信息*/
        Notice notice = noticeService.findById(id);
        model.addAttribute("notice",notice);
        return  "notice/prevNotice";
    }






}
