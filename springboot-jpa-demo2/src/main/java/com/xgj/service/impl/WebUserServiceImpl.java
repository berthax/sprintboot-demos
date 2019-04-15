package com.xgj.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xgj.entity.WebUser;
import com.xgj.redpository.WebUserRepository;
import com.xgj.service.WebUserService;

@Service
public class WebUserServiceImpl implements WebUserService{

	@Autowired
	private WebUserRepository webUserRepository;
	
	@Override
	public Page<WebUser> findAll(WebUser webUser, Pageable pageable) {
		
		Page<WebUser> pageUser = webUserRepository.findAll(
				//root应该就是来获得字段的。
				//CriteriaBuilder 是用来拼装查询条件的。 如like  equal greaterThanOrEqualTo ......
				//将每一个Predicate添加到list，然后使用CriteriaQuery进行查询。
				(Root<WebUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)->{
					List<Predicate> predicates = new ArrayList<Predicate>();
					predicates.add(criteriaBuilder.like(root.get("userName").as(String.class), "%"+webUser.getUserName() + "%"));
					predicates.add(criteriaBuilder.like(root.get("email").as(String.class), "%"+webUser.getEmail() + "%"));
					predicates.add(criteriaBuilder.like(root.get("phoneNo").as(String.class), "%"+webUser.getPhoneNo() + "%"));
					predicates.add(criteriaBuilder.equal(root.get("isValid").as(String.class), webUser.getIsValid()));
					
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
					try {
						if (null != webUser.getCreateTimeStart() && !"".equals(webUser.getCreateTimeStart()))
							predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(Date.class),
									f.parse(webUser.getCreateTimeStart())));
						if (null != webUser.getCreateTimeEnd() && !"".equals(webUser.getCreateTimeEnd()))
							predicates.add(criteriaBuilder.lessThan(root.get("createTime").as(Date.class),
									new Date(f.parse(webUser.getCreateTimeEnd()).getTime() + 24 * 3600 * 1000)));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
				}, pageable);
		
		return pageUser;
	}

	@Transactional
	@Override
	public WebUser save(WebUser webUser) {		
		return webUserRepository.save(webUser);
	}

	@Transactional
	@Override
	public void deleteOne(int id) {
		// TODO Auto-generated method stub
		webUserRepository.deleteById(id);
	}

	@Transactional
	@Override
	public WebUser update(WebUser webUser) {
		return webUserRepository.save(webUser);
	}

	@Override
	public WebUser findOne(int id) {
		return webUserRepository.findById(id).get();
	}

}
