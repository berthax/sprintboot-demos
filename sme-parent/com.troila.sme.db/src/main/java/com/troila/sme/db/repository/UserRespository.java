package com.troila.sme.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.troila.sme.db.entity.UserNativeQuery;
@Repository
public interface UserRespository extends JpaRepository<UserNativeQuery, Integer> {
	
	public List<UserNativeQuery> findByName(String username);
	
	@Query(value="select * from user where name= ?1 or age= ?2",nativeQuery=true)
	public List<UserNativeQuery> findByNameOrAge(String username,int age);
	
	@Query(value="select u.id as id,u.age as age,u.address_id as address_id, u.name as name,a.label as label,a.address_detail as  address_detail "
			+ "from user u left join address a on u.address_id = a.id where u.id = ?1",nativeQuery=true)
	public UserNativeQuery getUserWithAddrByid(int id);
	
	
}
