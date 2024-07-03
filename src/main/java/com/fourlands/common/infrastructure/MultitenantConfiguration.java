package com.fourlands.common.infrastructure;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
public class MultitenantConfiguration {

    @Value("${defaultTenant}")
    private String defaultTenant;

    @Value("${isRunLocal}")
    private boolean isRunLocal;

    private static final Logger LOGGER = Logger.getLogger(MultitenantConfiguration.class.getName());

    private Map<Object, Object> resolvedDataSources = new HashMap<>();

    @Autowired
    private Map<String, Properties> tenantPropertiesMap = new HashMap<>();

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DataSource dataSource() {
        Resource[] resources;
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
            resources = resolver.getResources("classpath:allTenants/*.properties");
        } catch (IOException e) {
            LOGGER.severe("Could not load resources from classpath:allTenants/*.properties.");
            throw new RuntimeException("Could not load resources from classpath:allTenants/*.properties.", e);
        }

        for (Resource resource : resources) {
            Properties tenantProperties = new Properties();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            try (InputStream inputStream = resource.getInputStream()) {
                tenantProperties.load(inputStream);
                String tenantId = tenantProperties.getProperty("name");
                String usernameEnv = System.getenv(tenantProperties.getProperty("datasource.username"));
                String passwordEnv = System.getenv(tenantProperties.getProperty("datasource.password"));
                String urlEnv = System.getenv(tenantProperties.getProperty("datasource.url"));
                dataSourceBuilder.driverClassName(tenantProperties.getProperty("datasource.driver-class-name"));
                dataSourceBuilder.username(usernameEnv);
                dataSourceBuilder.password(passwordEnv);
                dataSourceBuilder.url(urlEnv);

                LOGGER.info("Configuring datasource for tenant: " + tenantId);
                LOGGER.info("Using environment variables: " + usernameEnv + ", " + passwordEnv + ", " + urlEnv);

                if (isRunLocal && tenantId.equals("tenant_local"))
                    resolvedDataSources.put(tenantId, dataSourceBuilder.build());
                if (!isRunLocal && !tenantId.equals("tenant_local"))
                    resolvedDataSources.put(tenantId, dataSourceBuilder.build());

                tenantPropertiesMap.put(tenantId, tenantProperties);

            } catch (IOException exp) {
                throw new RuntimeException("Problem in tenant datasource:" + exp);
            }
        }

        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
        dataSource.setTargetDataSources(resolvedDataSources);

        dataSource.afterPropertiesSet();
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.fourlands.persistence.entity"); // Paquete donde están tus entidades JPA

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Configuración específica para cada tenant
        em.setJpaPropertyMap(getJpaPropertiesForTenant(defaultTenant));

        return em;
    }

    private Map<String, Object> getJpaPropertiesForTenant(String tenantId) {
        Properties tenantProperties = tenantPropertiesMap.get(tenantId);
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "none");
        jpaProperties.put("hibernate.dialect", tenantProperties.getProperty("hibernate.dialect"));
        return jpaProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


}