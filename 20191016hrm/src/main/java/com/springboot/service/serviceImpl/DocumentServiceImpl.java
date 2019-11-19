package com.springboot.service.serviceImpl;

import com.springboot.bean.Document;
import com.springboot.mapper.DocumentMapper;
import com.springboot.service.DocumentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public  class DocumentServiceImpl implements DocumentService {

    /*持有mapper对象*/
    @Autowired
    DocumentMapper documentMapper;

    /*上传文件*/
    @Override
    public void saveDocument(Document document) {
        documentMapper.add(document);
    }

    /*查询所有的文件*/
    @Override
    public List<Document> find() {
        return documentMapper.findUsers(null);
    }

    /*模糊查询*/
@Override
    public List<Document> selectByTitle(String title) {
        Map<String,Object> map=new HashMap<String, Object>();
        if(StringUtils.isNotEmpty(title)){
         map.put("title","%"+title+"%");
        }
        return documentMapper.findUsers(map);
    }

    /*查询指定id的文件*/
    @Override
    public Document findDocumentById(Integer id) {
        return documentMapper.getUser(id);
    }

    /*删除*/
    public void delete(Integer id){
        documentMapper.deleteById(id);
    }

    /*修改操作*/
    public void update(Document document){
        documentMapper.updateById(document);
    }


}
