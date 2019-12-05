package com.froyo.spring.config.databases;

import com.froyo.spring.config.databases.datasources.DataSourcePostgresConfig;
import com.froyo.spring.config.databases.jpa.JPAPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourcePostgresConfig.class, JPAPostgresConfig.class})
public class PostgresConfig {
}
