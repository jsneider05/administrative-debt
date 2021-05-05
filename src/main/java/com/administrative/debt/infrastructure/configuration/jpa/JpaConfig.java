package com.administrative.debt.infrastructure.configuration.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {
    "com.administrative.debt.infrastructure.entity"
})
@EnableJpaRepositories(basePackages = {
    "com.administrative.debt.infrastructure.adapter"
})
public class JpaConfig {

}
