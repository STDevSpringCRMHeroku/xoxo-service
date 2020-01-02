package com.froyo.config.jpa;

import com.froyo.jpa.mysql.entity.DomainPackagesMysql;
import com.froyo.jpa.mysql.repository.RepositoryPackageMysql;
import lombok.AllArgsConstructor;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@AllArgsConstructor
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager",
        basePackageClasses = RepositoryPackageMysql.class
)
public class JPAMysqlConfig {

    private final Environment env;
    private final DataSource datasourceMysql;

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourceMysql);
        entityManagerFactoryBean.setPackagesToScan(DomainPackagesMysql.class.getPackageName());
        //entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("mysql");

        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        //entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mysqlEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("mysql.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("mysql.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.properties.hibernate.ddl-auto"));
        return properties;
    }

    //private JpaVendorAdapter vendorAdaptor() {
    //final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    // put all the adapter properties here, such as show sql

    //vendorAdapter.setShowSql(env.getProperty("postgresql.jpa.show-sql", Boolean.class)); 	//Solo para que nos muestre las sentencias.
    //vendorAdapter.setDatabasePlatform(env.getProperty("postgresql.jpa.properties.hibernate.dialect",String.class));
    //vendorAdapter.setGenerateDdl(true);

    //return vendorAdapter;
    //}

}
