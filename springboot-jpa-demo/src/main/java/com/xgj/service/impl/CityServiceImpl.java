package com.xgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.entity.City;
import com.xgj.redpository.CityRepository;
import com.xgj.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public City insert(City city) {
		return cityRepository.insert(city);
	}

	@Override
	public City save(City city) {
		// TODO Auto-generated method stub
		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
	
}
