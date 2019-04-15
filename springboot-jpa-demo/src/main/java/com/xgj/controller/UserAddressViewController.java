package com.xgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.UserAddressView;
import com.xgj.redpository.UserAddressViewRepository;

@RestController
public class UserAddressViewController {
	
	@Autowired
	private UserAddressViewRepository userAddressViewRepository;
	
	@RequestMapping("/userview/byid")
	public UserAddressView findById(@RequestParam long id) {
		return userAddressViewRepository.getOne(id);
	}
}
