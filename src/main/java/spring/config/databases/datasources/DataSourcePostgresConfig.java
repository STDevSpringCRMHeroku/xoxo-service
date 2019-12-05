package spring.config.databases.datasources;

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
@ConfigurationProperties(prefix = "postgresql.datasource")
@EnableTransactionManagement
public class DataSourcePostgresConfig extends HikariConfig {

    @Bean(name = "datasourcePostgres")
    public DataSource datasourcePostgres() {
        return new HikariDataSource(this);
    }

    @Bean(name = "jdbcTemplatePostgres")
    public JdbcTemplate jdbcTemplate(DataSource datasourcePostgres) {
        return new JdbcTemplate(datasourcePostgres);
    }

    @Bean(name = "namedJdbcTemplatePostgres")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource datasourcePostgres) {
        return new NamedParameterJdbcTemplate(datasourcePostgres);
    }

}
