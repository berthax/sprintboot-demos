package com.xgj.redpository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xgj.entity.City;

public interface CityRepository extends MongoRepository<City, Long>{
	
}
