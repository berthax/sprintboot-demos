package com.xgj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
/**
 * 注意父类种的字段一定要定义成protected，不能是private，否则子类无法继承
 * 此类为所有实体类的基类，建表时，所有表都应该有如下字段
 */
@MappedSuperclass //表明这是父类，可以将属性映射到子类中使用JPA生成表
public abstract class BaseEntity{
	
	
	/**
	 * 无意义自增主键,按照数据库设计原则，主键应该是无意义自增主键
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",columnDefinition="int(10) comment '无意义自增主键'")
	protected Integer id; 
	
	/**
	 * 创建时间
	 */
	@Column(name="gmt_create",columnDefinition="DATETIME comment '创建时间'")
	protected Date gmtCreate; 
	
	/**
	 * 创建时间
	 */
	@Column(name="gmt_modified",columnDefinition="DATETIME comment '创建时间'")
	protected Date gmtModified; 
	
	/**
	 * 版本号，@version  乐观锁
	 */
	@Version   					
	@Column(name="version",nullable=false,columnDefinition="int(10) comment '版本号'")
	protected Integer version;
	
	/**
	 * 是否启用
	 */
	@Column(length=1,name="is_valid",nullable=false,columnDefinition="int(1) default '1' comment '是否启用，1:启用     0:不启用'")
	protected Integer isValid;
	
	@Transient
	protected String createTimeStart;  //创建时间的开始点
	@Transient
	protected String createTimeEnd; //创建时间的结束点

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	
}
