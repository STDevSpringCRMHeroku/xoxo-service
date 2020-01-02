package com.froyo.config.jpa;

import com.froyo.jpa.postgres.entity.DomainPackagesPostgres;
import com.froyo.jpa.postgres.repository.RepositoryPackagePostgres;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@AllArgsConstructor
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackageClasses = RepositoryPackagePostgres.class
)
public class JPAPostgresConfig {

    private final Environment env;
    private final DataSource datasourcePostgres;

    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourcePostgres);
        entityManagerFactoryBean.setPackagesToScan(DomainPackagesPostgres.class.getPackageName());
        entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        //entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //entityManagerFactoryBean.setPersistenceUnitName("postgres");

        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        //entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("postgresql.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("postgresql.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("postgresql.jpa.properties.hibernate.ddl-auto"));
        return properties;
    }

    private JpaVendorAdapter vendorAdaptor() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // put all the adapter properties here, such as show sql

        //vendorAdapter.setShowSql(env.getProperty("postgresql.jpa.show-sql", Boolean.class)); 	//Solo para que nos muestre las sentencias.
        //vendorAdapter.setDatabasePlatform(env.getProperty("postgresql.jpa.properties.hibernate.dialect",String.class));
        //vendorAdapter.setGenerateDdl(true);

        return vendorAdapter;
    }

}
