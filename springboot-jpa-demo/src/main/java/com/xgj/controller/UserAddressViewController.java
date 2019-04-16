package com.xgj.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.UserAddressView;
import com.xgj.redpository.UserAddressViewRepository;
/**
 * Jpa操作视图示例（此种方法，其实是将联表查询的过程放在了数据库端，程序端只是简单的取结果）
 * @author xuanguojing
 *
 */
@RestController
public class UserAddressViewController {
	
	@Autowired
	private UserAddressViewRepository userAddressViewRepository;
	
	@RequestMapping("/userview/byid")
	public UserAddressView findById(@RequestParam long id) {
		Optional<UserAddressView> result = userAddressViewRepository.findById(id);
//		return userAddressViewRepository.getOne(id);
		return result.get();
	}
}
