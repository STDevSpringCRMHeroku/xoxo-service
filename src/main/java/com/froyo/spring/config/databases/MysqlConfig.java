package com.froyo.spring.config.databases;

import com.froyo.spring.config.databases.datasources.DataSourceMysqlConfig;
import com.froyo.spring.config.databases.jpa.JPAMysqlConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}
