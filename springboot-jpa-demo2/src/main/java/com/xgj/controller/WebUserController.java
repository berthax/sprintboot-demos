package com.xgj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.WebUser;
import com.xgj.service.WebUserService;

@RestController
@RequestMapping("/webuser")
public class WebUserController {
	
	
	@Autowired
	private WebUserService webUserService;
	
	/**
	 * 分页查询所有用户（动态页数，每页大小，排序方式，排序字段）
	 * 包括动态条件查询（用户名，email，电话，是否启用，创建时间）
	 * 规则：无输入条件，默认查询全部。默认返回第一页 每页5条，默认asc排序，默认id排序。
	 */
	@RequestMapping(value="/findAll",method={RequestMethod.POST,RequestMethod.GET})
	public Page<WebUser> findAll(@PageableDefault Pageable pageable,WebUser webUser){
		return webUserService.findAll(webUser, pageable);
	}
	
	/**
	 * 添加
	 */
	@PostMapping(value="/save.do")
	public String save(WebUser webUser){
		webUser.setGmtCreate(new Date());
		webUser.setIsValid(1);
		webUser.setVersion(2);
		webUser.setGmtCreate(new Date());
		webUser.setGmtModified(new Date());
		System.out.println(webUser.toString());
		WebUser webUser2 = webUserService.save(webUser);
		if(webUser2!=null) 
			return "success";
		else 
			return "fail";
	}


}
