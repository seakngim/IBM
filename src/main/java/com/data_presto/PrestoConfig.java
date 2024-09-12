package com.data_presto;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PrestoConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.facebook.presto.jdbc.PrestoDriver")
                .url("jdbc:presto://dfc14c37-9185-4336-95ac-f734b6bb62cd.co1u05ot0jqujbai8j2g.lakehouse.appdomain.cloud:31384/iceberg_data?SSL=true")
                .username("ibmlhapikey")
                .password("8BTw1wttn0Vmcs8t8tRQailLGyAfYSs8Nl0aABQ4Y-i3")
                .build();
    }
}
