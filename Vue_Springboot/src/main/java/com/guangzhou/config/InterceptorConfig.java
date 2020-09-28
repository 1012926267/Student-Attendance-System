package com.guangzhou.config;

import com.guangzhou.interceptors.JWTInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/teacher/login","/teacher/register","/resources/static");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
/*        registry.addResourceHandler("/**") //代表以什么样的请求路径访问静态资源
                .addResourceLocations("classpath:/static/avatar/**");*/
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}
