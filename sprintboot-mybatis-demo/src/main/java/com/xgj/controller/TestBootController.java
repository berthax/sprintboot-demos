package com.xgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xgj.entity.User;
import com.xgj.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("/getuser1")
    public User getUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("test-user1");
        user.setPassword("123456");
        user.setRealname("测试用户1");
        return user;
    }
	 
    @RequestMapping("/getUser/{id}")
    public String GetUser(@PathVariable int id){
    	return null;
    }
    
    @RequestMapping("/getUser/ByPage")
    public PageInfo<User> GetUserByPage(){
    	return userService.findAllByPage(0, 10);
    }
}
