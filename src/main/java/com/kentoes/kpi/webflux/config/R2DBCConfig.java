package com.kentoes.kpi.webflux.config;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class R2DBCConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        MariadbConnectionConfiguration build = MariadbConnectionConfiguration.builder()
                .host(System.getenv("DB_HOST")).port(Integer.parseInt(System.getenv("DB_PORT")))
                .username(System.getenv("DB_USER")).password(System.getenv("DB_PASS"))
                .database(System.getenv("DB_SCHEMA")).build();
        log.info(build.toString());
        return new MariadbConnectionFactory(build);
    }
//
//    @Bean
//    public R2dbcEntityTemplate r2dbcEntityTemplate() {
//        return new R2dbcEntityTemplate(connectionFactory());
//    }
}
