package com.xgj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String name;
	public String cityname;
	public String citycode;
	public String provincename;
	public String provincecode;
	public String completeaddress;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCityname() {
		return cityname;
	}


	public void setCityname(String cityname) {
		this.cityname = cityname;
	}


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getProvincename() {
		return provincename;
	}


	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}


	public String getProvincecode() {
		return provincecode;
	}


	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}


	public String getCompleteaddress() {
		return completeaddress;
	}


	public void setCompleteaddress(String completeaddress) {
		this.completeaddress = completeaddress;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", cityname=" + cityname + ", citycode=" + citycode
				+ ", provincename=" + provincename + ", provincecode=" + provincecode + ", completeaddress="
				+ completeaddress + "]";
	}
	
}
