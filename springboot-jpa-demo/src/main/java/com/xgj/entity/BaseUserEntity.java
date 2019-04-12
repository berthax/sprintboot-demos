package com.xgj.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * 用户类的基类 
 * 邮箱和手机号不能重复
 * @author xuanguojing
 *
 */
@MappedSuperclass
public abstract class BaseUserEntity extends BaseEntity {
	
	@Column(length=255,name="user_name",nullable=false,columnDefinition="varchar(255) unique comment '用户名'")
	protected String userName;
	
	@Column(length=32,name="password",nullable=false,columnDefinition="varchar(32) default '000000' comment '密码'")
	protected String password;
	
	@Column(length=64,name="email",nullable=false,columnDefinition="varchar(64) unique comment '邮箱'")
	protected String email;
	
	@Column(length=11,name="phone_no",nullable=false,columnDefinition="varchar(11) unique comment '电话号码'")
	protected String phoneNo; //手机号
	
	@Column(length=32,name="real_name",nullable=false,columnDefinition="varchar(32) comment '真实姓名'")
	protected String realName; //真实姓名

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
