package com.xgj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alibaba.fastjson.JSONObject;

@Entity(name="address")
public class Address extends BaseEntity{
	
	@Column(name="label",nullable=false,columnDefinition="varchar(16) comment '地址标签（家、公司）'")
	private String label;
 
	@Column(name="country",nullable=false,columnDefinition="varchar(16) comment '国家'")
	private String country;
	
	@Column(name="province",nullable=false,columnDefinition="varchar(32) comment '省份'")
	private String province;
	
	@Column(name="city",nullable=false,columnDefinition="varchar(32) comment '城市'")
	private String city;
	
	@Column(name="address",nullable=false,columnDefinition="varchar(255) comment '具体地址'")
	private String address;
	
	/**
	 * 
	 * @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=true)
	 * address表为“一对多”中的多，所以使用@ManyToOne注解，并且配合@JoinColumn注解使用。
	 * 如果单独使用@ManyToOne，那么会生成一张中间表来维护两张表关系，如果不想使用中间表使用@JoinColumn来生成外键维护两张表关系。
	 * name="webUser_id"，表示生成的外键名称，并且字段类型以webUser表的主键为准。
	 * 
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="webUser_id",nullable=true)
	private WebUser webUser;
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this,true);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}
}
