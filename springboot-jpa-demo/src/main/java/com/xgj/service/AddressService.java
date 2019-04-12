package com.xgj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xgj.entity.Address;

public interface AddressService {
	
	public Address save(Address address);
	
	public Page<Address> findAll(Address address,Pageable pageable);
}
