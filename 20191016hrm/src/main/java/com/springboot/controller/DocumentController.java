package com.springboot.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springboot.bean.Document;
import com.springboot.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class DocumentController {


    @Autowired
    DocumentService documentService;

    /*跳转到文件上传页面*/
    @RequestMapping("/document/toAddDocument")
    public String toAddDocument(){
        return "document/addDocument";
    }

    /*处理文件上传请求操作*/
    @RequestMapping("/document/addDocument")
    public void addDocument(HttpServletResponse response, HttpServletRequest request, MultipartFile file, Document document) throws IOException, IllegalStateException{

        /*保存文件上传的路劲*/
        String realPath = request.getServletContext().getRealPath("/images/document");

        /*获取文件的文件*/
        String originalFilename = file.getOriginalFilename();

        /*拼接新文件名*/
        String newFilename= UUID.randomUUID().toString()+originalFilename;

        /*设置保存文件的全路径*/
        String savePath=realPath+ File.separator+newFilename;

        file.transferTo(new File(savePath));

        /*封装文件的路径*/
        document.setUrl(savePath);
        /*设置上传文件的时间*/
        document.setCreateDate(new Date());
        /*设置用户id*/
        document.setUserId(1);
        /*调用文件上传方法*/
        documentService.saveDocument(document);
    }

    /*跳转到下载文件地方*/
    @RequestMapping("/document/documentList")
    public String documentList(Model model){
        /*查询所有文件*/
        List<Document> documents=documentService.find();
        /*设置数据到域中*/
        model.addAttribute("documents",documents);
        return "/document/documentList";
    }

    /*模糊查询*/
    @RequestMapping("/document/selectDocument")
    public String selectByTitle(Model model,String title){
        /*根据文件标题搜索文件*/
        List<Document> documents=documentService.selectByTitle(title);
        /*设置数据到域中*/
        model.addAttribute("documents",documents);
        return "/document/documentList";
    }

    /*文件下载功能*/
    @RequestMapping("/document/downDocument")
    public void downDocument(String id,HttpServletResponse response){
        /*查询指定id的文件*/
        Document document = documentService.findDocumentById(Integer.parseInt(id));
        String url = document.getUrl();

        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+url);

        /*定义一个byte类型数组*/
        byte[] buff=new byte[1024];
        BufferedInputStream bis=null;
        OutputStream os=null;
        try {
            os=response.getOutputStream();
            bis=new BufferedInputStream(new FileInputStream(new File(url)));
            while (bis.read(buff)!=-1){
                os.write(buff,0,buff.length);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*删除功能*/
    @RequestMapping("document/deleteDocument")
    public void delete(Integer id,HttpServletResponse response)  {
        documentService.delete(id);
        try {
            response.sendRedirect("/document/documentList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*跳转到修改页面*/
    @RequestMapping("/document/toUpdateDocument")
    public String toUpdateDocument(Integer id,Model model){
        Document document = documentService.findDocumentById(id);
        model.addAttribute("document",document);
        return "/document/updateDocument";
    }

    /*修改操作*/
    @RequestMapping("/document/updateDocument")
    public String updateDocument(Document document){
        documentService.update(document);
        return "redirect:/document/documentList";
    }






}
