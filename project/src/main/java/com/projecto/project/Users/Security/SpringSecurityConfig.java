package com.projecto.project.Users.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
        "classpath:/META-INF/resources/", "classpath:/resources/",
        "classpath:/static/", "classpath:/public/" };

    @Override
    public void addViewControllers(@SuppressWarnings("null") ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("logIn");
        registry.addViewController("/index").setViewName("logIn");
        registry.addViewController("/survey").setViewName("newSurvey");
    }

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("");
    }

    

    @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }



    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/api/categories/**").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/api/surveyjson", "api/surveyjson/**").permitAll()
                .requestMatchers("/survey").permitAll()
                .requestMatchers("/static/**").permitAll()
                .requestMatchers("/api/categories").permitAll()
                .requestMatchers("/api/users").permitAll()
                .requestMatchers("/survey/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/survey").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/survey").permitAll()
                .requestMatchers("/chapter/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/chapter").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/chapter").permitAll()
                .requestMatchers("/question/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/question").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/question").permitAll()
                .requestMatchers("/catalog/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/users/verify").permitAll()

                .anyRequest().authenticated())
                
                // .formLogin((form) -> form
                // .loginPage("/index").permitAll())
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(form -> form
                    .loginPage("/index").permitAll())   
                .build();

    }

}
