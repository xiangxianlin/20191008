package com.springboot.service;

import com.springboot.bean.Document;

import java.util.List;

public interface DocumentService {
    /*文件上传操作*/
    public void saveDocument(Document document);

    /*查询文件*/
    public List<Document> find();

    /*根据文件标题模糊查询*/
    public List<Document> selectByTitle(String title);

    /*查询指定id的文件*/
    public Document findDocumentById(Integer id);

    /*删除*/
    public void delete(Integer id);

    /*修改操作*/
    public void update(Document document);

}
