package com.example.Webbansach_backend.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RepositoryRestConfig {

    @Autowired
    private EntityManager entityManager;

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(config ->
                config.exposeIdsFor(
                        entityManager.getMetamodel()
                                .getEntities()
                                .stream()
                                .map(EntityType::getJavaType)
                                .toArray(Class[]::new)
                )
        );
    }
}
