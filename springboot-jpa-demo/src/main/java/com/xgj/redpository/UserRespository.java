package com.xgj.redpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xgj.entity.User;

public interface UserRespository extends JpaRepository<User, Integer> {
	
	public List<User> findByName(String username);
	
	@Query(value="select * from user where name= ?1 or age= ?2",nativeQuery=true)
	public List<User> findByNameOrAge(String username,int age);
	
}
