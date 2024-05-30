package com.fourlands.common.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
public class MultitenantConfiguration {

    @Value("${defaultTenant}")
    private String defaultTenant;

    private static final Logger LOGGER = Logger.getLogger(MultitenantConfiguration.class.getName());

    @Bean
    public DataSource dataSource() {
        File[] files = Paths.get("src/main/resources/allTenants").toFile().listFiles();
        Map<Object, Object> resolvedDataSources = new HashMap<>();

        for (File propertyFile : files) {
            Properties tenantProperties = new Properties();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            try {
                tenantProperties.load(new FileInputStream(propertyFile));
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

                resolvedDataSources.put(tenantId, dataSourceBuilder.build());

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


}