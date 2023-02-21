package com.daniellesko.springboot101.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    // DataSource vytvoreny specifikovanim jeho parametrov v application.properties
    // takze do jdbcTemplate je injecknuty Datasource z ApplicationContext
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

}
