package com.troila.sme.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.troila.sme.db.entity.UserNativeQuery;
import com.troila.sme.manage.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	//此处只用来测试，理论上来说，controller层不应该直接操作仓储层，只应该操作业务层
	/*@Autowired
	private UserRespository userRespository;*/
	@Autowired
	private UserService userService;
	
	/*@GetMapping("/list")
	public List<UserNativeQuery> getUserList(){
		return userRespository.findAll();
	}*/
	@GetMapping("/query")
	public List<UserNativeQuery> getUserByCondition(@RequestParam String name,int age){
		return userService.findByNameOrAge(name, age);
	}
	
	@GetMapping("/list/detail")
	public Object getUserListDetail(@RequestParam long id){
//		return userService.getUserWithAddrByid(id);
		return userService.findOne((int)id).get();
	}
	
	/*@GetMapping("/list/detail2")
	public UserNativeQuery getUserListDetail2(@RequestParam int id) {
		return userRespository.getUserWithAddrByid(id);
	}*/
	
}
