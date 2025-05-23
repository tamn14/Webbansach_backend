package com.example.Webbansach_backend.Config;

import com.example.Webbansach_backend.Entity.TheLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url = "http://localhost:5173" ;
    @Autowired
    private EntityManager entityManager;
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        HttpMethod[] DisableMethod = {
//                HttpMethod.POST ,
//                HttpMethod.PUT ,
//                HttpMethod.DELETE ,
//                HttpMethod.PATCH
//
//        } ;
        // Cors configuration
        cors.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");

        // cho phep expose id
        config.exposeIdsFor( entityManager.getMetamodel()
                .getEntities()
                .stream()
                .map(Type::getJavaType)
                .toArray(Class[]::new) );

//        // Chặn các method DELETE
//        HttpMethod[] phuongThucDelete = {
//                HttpMethod.DELETE
//        };
//        disableHttpMethods(TheLoai.class, config,phuongThucDelete );
    }
    private void disableHttpMethods(Class c,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] methods){
        config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
    }
}

