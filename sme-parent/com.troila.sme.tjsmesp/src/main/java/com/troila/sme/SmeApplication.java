package com.troila.sme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages="com.troila.sme")
//@ComponentScan(basePackages={"com.troila.sme"})
//@ComponentScan(value="com")
//@EnableJpaRepositories(basePackages= {"com.troila.sme"})
@SpringBootApplication
//@EnableAutoConfiguration
public class SmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmeApplication.class, args);
	}

}
