package com.cloudscene.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gin
 * @date 2022/4/21
 * @description WebMVCConfig
 */

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，8080端口和8888端口
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

}
