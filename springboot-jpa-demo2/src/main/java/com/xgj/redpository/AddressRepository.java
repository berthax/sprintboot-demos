package com.xgj.redpository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xgj.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	public Page<Address> findAll(Specification<Address> specification,Pageable pageable);
}
