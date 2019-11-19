package com.springboot.bean;

import org.apache.ibatis.type.Alias;

/**
 * User 数据传输类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 13:40:41
 * @version 1.0
 */
@Alias("User")
public class User implements java.io.Serializable{

	/*实现serializable接口后用工具生成的*/
	private static final long serialVersionUID = 1L;
	/*用户id*/
	private int id;
	/*用户姓名*/
	private String name;
	/*用户密码*/
	private String passWord;
	/*用户状态0和1*/
	private int status;
	/*创建日期*/
	private java.util.Date createDate;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	public String getPassWord(){
		return this.passWord;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

}