package com.xgj.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xgj.entity.Address;
import com.xgj.entity.WebUser;
import com.xgj.redpository.AddressRepository;
import com.xgj.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Page<Address> findAll(Address address,Pageable pageable) {
		Page<Address> pageAddress = addressRepository.findAll(
				(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)->{
					List<Predicate> predicates = new ArrayList<>();
					/*predicates.add(criteriaBuilder.like(root.get("country").as(String.class), "%" + address.getCountry() + "%"));
					predicates.add(criteriaBuilder.like(root.get("province").as(String.class), "%" + address.getProvince() + "%"));
					predicates.add(criteriaBuilder.like(root.get("city").as(String.class), "%" + address.getCity() + "%"));
					predicates.add(criteriaBuilder.like(root.get("address").as(String.class), "%" + address.getAddress() + "%"));*/
					
					if(null!=address.getId()&&!"".equals(address.getId()))
						predicates.add(criteriaBuilder.equal(root.get("id").as(Integer.class),address.getId()));
					if(null!=address.getWebUser()&&!"".equals(address.getWebUser()))
						predicates.add(criteriaBuilder.equal(root.<WebUser>get("webUser").<Integer>get("id"),address.getWebUser().getId()));
					
					return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
				}, pageable);
		return pageAddress;
	}

}
