package com.xgj.entity;

public class UserWithAddress extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String addressname;
	
	private String completeaddress;

	public String getAddressname() {
		return addressname;
	}

	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}

	public String getCompleteaddress() {
		return completeaddress;
	}

	public void setCompleteaddress(String completeaddress) {
		this.completeaddress = completeaddress;
	}
	
	
}
