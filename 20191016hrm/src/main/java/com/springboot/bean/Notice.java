package com.springboot.bean;

import org.apache.ibatis.type.Alias;

/**
 * Notice 数据传输类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 13:40:41
 * @version 1.0
 */
@Alias("Notice")
public class Notice implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/*通知id*/
	private int id;
	/*通知标题*/
	private String title;
	/*通知内容*/
	private String content;
	/*通知的创建时间*/
	private java.util.Date createDate;

	private int userId;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}

}