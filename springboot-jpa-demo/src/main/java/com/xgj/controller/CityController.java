package com.xgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xgj.entity.City;
import com.xgj.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public City saveCity(@RequestBody City city) {
		return cityService.save(city);
	}
	
	@GetMapping(value="/findAll")
	public List<City> findAll(){
		return cityService.findAll();
	}
}
