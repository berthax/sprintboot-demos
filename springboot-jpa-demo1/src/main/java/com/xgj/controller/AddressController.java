package com.xgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.Address;
import com.xgj.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/list")
	public List<Address> getAddressList(){
		return addressService.listAddress();
	}
	
	@GetMapping("/query")
	public Address getAddressByid(@RequestParam long id){
		return addressService.getAddressByid(id);
	}
}
