package com.xgj.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.entity.User;
import com.xgj.entity.UserWithAddress;
import com.xgj.redpository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> findByName(String username) {
		return userRespository.findByName(username);
	}
	
	public List<User> findByNameOrAge(String name,int age){
		return userRespository.findByNameOrAge(name, age);
	}
	
	/**
	 * jpa实现多表联查;
	 * @param id
	 * @return
	 */
	@Transactional
	public Object getUserWithAddrByid(Long id) {
		/*List resultList = entityManager.createNativeQuery(
				"select u.id id,u.age age,u.name name,a.name aname,a.completeaddress address from user u left join address a on u.address_id = a.id where u.id = :id")
				.setParameter("id", id).getResultList();*/
/*		UserWithAddress result = (UserWithAddress)entityManager.createNativeQuery(
				"select u.id id,u.age age,u.name name,a.name aname,a.completeaddress address from user u left join address a on u.address_id = a.id where u.id = :id")
				.setParameter("id", id).getSingleResult();*/
		
		Object result = entityManager.createNativeQuery(
				"select u.id id,u.age age,u.name name,a.name aname,a.completeaddress address from user u left join address a on u.address_id = a.id where u.id = :id")
				.setParameter("id", id).getSingleResult();
		
		return result;
	}
}
