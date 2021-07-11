package com.hrm.oa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //进行跨域请求，表示所有的地址都可以访问，不用像以前一样要指定前端的端口号要和后端定义的端口号一致才能访问，访问后端之后，前端才能拿到数据。
        /*这里有个bug，可能是连接云数据库的原因，所以不能访问本地的  http://localhost:8081/ ,只能访问 http://192.168.0.177:8081/这个地址
        不然前端拿不到后端响应的值*/
        registry.addMapping("/**")
//                .allowedOriginPatterns("*")
                .allowedOrigins("*")
                .allowedHeaders(CorsConfiguration.ALL)
                //所有请求都允许，比如说post,get,del,put请求
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
    }

}
