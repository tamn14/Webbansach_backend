package com.example.Webbansach_backend.Sercurity;


import com.example.Webbansach_backend.Filter.JwtFilter;
import com.example.Webbansach_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFiler ;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider() ;
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider ;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                config -> config
                        .requestMatchers(HttpMethod.GET, Endpoint.PUBLIC_GET_ENPOINT).permitAll()
                        .requestMatchers(HttpMethod.POST, Endpoint.PUBLIC_POST_ENDPOINS).permitAll()
                        .requestMatchers(HttpMethod.GET, Endpoint.ADMIN_GET_ENDPOINS).hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, Endpoint.ADMIN_POST_ENDPOINS).hasAuthority("ADMIN")
        );
        http.cors(cors -> {
            cors.configurationSource(request -> {
                CorsConfiguration corsConfig = new CorsConfiguration();
                corsConfig.addAllowedOrigin(Endpoint.front_end_host);
                corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                corsConfig.addAllowedHeader("*");
                return corsConfig;
            });
        });
        http.addFilterBefore(jwtFiler, UsernamePasswordAuthenticationFilter.class) ;
        http.sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) ;
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager() ;
    }



}
