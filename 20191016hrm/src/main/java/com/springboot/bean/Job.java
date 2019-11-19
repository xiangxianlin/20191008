package com.springboot.bean;

import org.apache.ibatis.type.Alias;

/**
 * Job 数据传输类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 13:40:41
 * @version 1.0
 */
@Alias("Job")
/*员工表*/
public class Job implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/*员工id*/
	private int id;
	/*员工姓名*/
	private String name;
	/*标记*/
	private String remark;

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
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}

}