package com.example.demo.config;

import com.example.demo.entity.Cat;
import com.example.demo.entity.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

//@Configuration(proxyBeanMethods = false)
@Configuration()
//@EnableConfigurationProperties(Cat.class)
public class MyConfig implements WebMvcConfigurer {
    @Bean("tom")
    public Cat cat() {
        return new Cat("test");
    }
    @Bean
    public User user(){
        User user = new User();
        user.setCat(cat());
        return user;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
