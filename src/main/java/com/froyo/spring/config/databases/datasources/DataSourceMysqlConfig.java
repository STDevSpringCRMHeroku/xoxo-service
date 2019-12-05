package com.froyo.spring.config.databases.datasources;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "mysql.datasource")
@EnableTransactionManagement
public class DataSourceMysqlConfig extends HikariConfig {

    @Bean(name = "datasourceMysql")
    public DataSource datasourceMysql() {
        return new HikariDataSource(this);
    }

    @Bean(name = "jdbcTemplateMysql")
    public JdbcTemplate jdbcTemplate(DataSource datasourceMysql) {
        return new JdbcTemplate(datasourceMysql);
    }

    @Bean(name = "namedJdbcTemplateMysql")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource datasourceMysql) {
        return new NamedParameterJdbcTemplate(datasourceMysql);
    }

}
