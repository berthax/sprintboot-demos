package com.troila.sme.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.troila.sme.db.entity")
@EnableJpaRepositories("com.troila.sme.db.repository")
@ComponentScan("com.troila.sme")
public class ComponentConfig {

}
