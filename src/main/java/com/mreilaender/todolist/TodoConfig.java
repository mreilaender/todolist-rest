package com.mreilaender.todolist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author manuel
 * @version 12/9/16
*/
@EnableWebMvc
@Configuration
public class TodoConfig {

    @Bean
    public WebMvcConfigurer corseConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {registry.addMapping("/**").allowedOrigins("https://mytodolist-react.herokuapp.com/");
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://mytodolist-react.herokuapp.com");
                        //.allowedOrigins("http://localhost:3000");
            }
         };
    }
}