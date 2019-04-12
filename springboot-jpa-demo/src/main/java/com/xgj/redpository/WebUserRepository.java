package com.xgj.redpository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xgj.entity.WebUser;

public interface WebUserRepository extends JpaRepository<WebUser, Integer>{
	
	public Page<WebUser> findAll(Specification<WebUser> specification,Pageable pageable);
}
