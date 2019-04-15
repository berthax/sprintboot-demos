package com.xgj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xgj.entity.WebUser;
/**
 * 定义接口，面向接口编程
 * @author xuanguojing
 *
 */
public interface WebUserService {
	
	/**
	 * 单表条件查询
	 */
	public Page<WebUser> findAll(WebUser webUser,Pageable pageable);
	
	/**
	 * 添加用户
	 * @param list
	 * @return
	 */
	public WebUser save(WebUser webUser);
	
	/**
	 * 单个删除
	 * @param user
	 */
	public void deleteOne(int id);
	
	/**
	 * 更新用户
	 */
	public WebUser update(WebUser webUser);
	
	/**
	 * 根据ID查找
	 */
	public WebUser findOne(int id);
}
