package com.example.OrderService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import com.datastax.oss.driver.api.core.CqlSession;
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "productskeyspace";
    }

    @Override
    protected String getContactPoints() {
        return "172.17.159.147";
    }

    @Override
    protected int getPort() {
        return 9042;
    }

    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession session) {
        return new CassandraTemplate(session);
    }
}