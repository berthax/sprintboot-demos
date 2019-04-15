package com.xgj.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.alibaba.fastjson.JSONObject;

/**
 * @Entity说明这是一个实体bean，使用orm默认规则（类名=表名；属性名=字段名）关联DB；
 * 如果想改变这种规则：1，可以配置@Entity的name来对应DB中的表名；@Entity(name="USER")
 * 				2，使用@Table来改变class和DB表名的映射规则；@Column来改变属性名和字段名的映射规则
 * 网站用户信息表
 * ID，用户名，邮箱号，手机号，微信ID都不可重复
 * 
 */
@Entity(name="web_user")
public class WebUser extends BaseUserEntity {
		
	@Column(length=32,columnDefinition="varchar(32) comment '昵称'")
	private String nickName;
	
	@Column(length=32,name="wx_id",columnDefinition="varchar(32) unique comment '微信号'")
	private String wxId; //微信ID
	
	/**
	 * @OneToMany(mappedBy="webUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 * webuser是用户实体，一个用户对应多个地址，所以webuser是“一对多”中的“一”。在一的实体中，使用此注解标注。
	 * mappedBy:标注该属性对应“多”的实体中的属性名。
	 * cascade 表示级联操作。
	 * fetch  加载方式，默认都是lazy加载
	 */
	@OneToMany(mappedBy="webUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Address> addresses;

	public WebUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebUser(String username) {
		this.userName = username;
	}
	
	
	
	@Override
	public String toString() {
//		return "WebUser [nickName=" + nickName + ", wxId=" + wxId + ", addresses=" + addresses + "]";
		return JSONObject.toJSONString(this,true);
//		return JacksonUtil.bean2Json(this);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}


}
