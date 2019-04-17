package com.troila.sme.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages={"com.troila.sme"})
@EnableAutoConfiguration
public class SmeManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmeManageApplication.class, args);
	}

}
