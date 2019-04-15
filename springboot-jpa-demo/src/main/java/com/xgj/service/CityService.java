package com.xgj.service;

import java.util.List;

import com.xgj.entity.City;

public interface CityService {
	/**
	 * 插入新纪录
	 * @param city
	 * @return
	 */
	public City insert(City city);
	
	/**
	 * 可插入新的，也可修改原来的（新的会覆盖原来的）
	 * @param city
	 * @return
	 */
	public City save(City city);
	
	public List<City> findAll();
	
}
