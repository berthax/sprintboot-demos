package com.xgj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.xgj.dao")
@MapperScan("com.xgj.dao")
public class SprintbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootMybatisApplication.class, args);
	}

}
