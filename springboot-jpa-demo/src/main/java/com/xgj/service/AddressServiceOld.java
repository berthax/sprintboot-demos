package com.xgj.service;
/*package com.xgj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.xgj.entity.Address_old;

@Service
public class AddressService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	*//**
	  *      使用java原生的jpa操作数据库示例
	 *       动态引入entitymanger,之后就能正常使用了
	 * @return
	 *//*
	public List<Address_old> listAddress(){
		List<Address_old> resultList = entityManager.createNativeQuery("select * from address ", Address_old.class).getResultList();
		return resultList;
	}
	
	*//**
	 * 
	 * createNativeQuery是操作原生mysql方法;支持跨表查询;
	 * jpa的事务 直接使用注解Transactional 参数rollbackon表示回滚条件, 这个注解一搬加在service层;  注意getSingleResult 如果查不到数据会报错;
	 *  在数据库插入，删除，更新的过程中要注意回滚
	 * @param id
	 * @return
	 *//*
	@Transactional(rollbackOn = {Exception.class})
	public Address_old getAddressByid(Long id) {
		Address_old singleResult = null;
		try {
			singleResult = (Address_old) entityManager
					.createNativeQuery("select * from address where id = :id", Address_old.class).setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleResult;
	}

}
*/