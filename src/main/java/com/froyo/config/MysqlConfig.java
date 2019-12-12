package com.froyo.config;

import com.froyo.config.datasources.DataSourceMysqlConfig;
import com.froyo.config.jpa.JPAMysqlConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}
