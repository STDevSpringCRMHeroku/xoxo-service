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
@ConfigurationProperties(prefix = "h2.datasource")
@EnableTransactionManagement
public class DataSourceH2Config extends HikariConfig {

    @Bean(name = "datasourceH2")
    public DataSource datasourceH2() {
        return new HikariDataSource(this);
    }

    @Bean(name = "jdbcTemplateH2")
    public JdbcTemplate jdbcTemplate(DataSource datasourceH2) {
        return new JdbcTemplate(datasourceH2);
    }

    @Bean(name = "namedJdbcTemplateH2")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource datasourceH2) {
        return new NamedParameterJdbcTemplate(datasourceH2);
    }

}
