package com.troila.sme.manage.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troila.sme.db.entity.UserNativeQuery;
import com.troila.sme.db.repository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespository;
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	public Optional<UserNativeQuery> findOne(int id) {
		return userRespository.findById(id);
	}
	
	public List<UserNativeQuery> findByName(String username) {
		return userRespository.findByName(username);
	}
	
	public List<UserNativeQuery> findByNameOrAge(String name,int age){
		return userRespository.findByNameOrAge(name, age);
	}
	
	/**
	 * jpa实现多表联查示例2，
	 *     使用entityManager创建NativeQuery进行查询，但是此处，结果的返回最好不用Object接收，指定接收的类型，否则别人不知道都有什么
	 * @param id
	 * @return
	 */
/*	@Transactional
	public UserNativeQuery getUserWithAddrByid(Long id) {
		List resultList = entityManager.createNativeQuery(
				"select u.id id,u.age age,u.name name,a.name aname,a.completeaddress address from user u left join address a on u.address_id = a.id where u.id = :id")
				.setParameter("id", id).getResultList();
		UserWithAddress result = (UserWithAddress)entityManager.createNativeQuery(
				"select u.id id,u.age age,u.name name,a.name aname,a.completeaddress address from user u left join address a on u.address_id = a.id where u.id = :id")
				.setParameter("id", id).getSingleResult();
		
		Object result = entityManager.createNativeQuery("select u.id id,u.age age,u.address_id address_id, u.name name,a.label label,a.address_detail address_detail from user u left join address a on u.address_id = a.id where u.id = :id",
									UserNativeQuery.class)
				.setParameter("id", id)
				.getSingleResult();
		
		//注意此处获得的结果，label和addressDetail是没有值的，显示为null，原因是什么呢
		return (UserNativeQuery)result;
	}*/
}
