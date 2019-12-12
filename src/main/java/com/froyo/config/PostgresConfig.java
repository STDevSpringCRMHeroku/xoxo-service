package com.froyo.config;

import com.froyo.config.datasources.DataSourcePostgresConfig;
import com.froyo.config.jpa.JPAPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourcePostgresConfig.class, JPAPostgresConfig.class})
public class PostgresConfig {
}
