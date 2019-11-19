package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AjaxUploadController {

    /*ajax异步请求文件上传*/
    @RequestMapping("/notice/uploadPic")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request){
        /*获取到保存文件的路径realpath*/
        String realPath = request.getServletContext().getRealPath("/images/notice");
        /*获取上传文件名*/
        String newFilename = UUID.randomUUID().toString()+"."+file.getOriginalFilename();
        try {
            /*文件上传的方法*/
            file.transferTo(new File(realPath+File.separator+newFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/images/notice/"+newFilename;
    }


}
