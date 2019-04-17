package com.troila.sme.tjsmesp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.troila.sme.db.ComponentConfig;

@Configuration
@Import(ComponentConfig.class)
public class PoConfig {

}
