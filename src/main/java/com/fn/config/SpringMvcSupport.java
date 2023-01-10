package com.fn.config;

import com.fn.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * springboot整合mybatis和SSM
 * 456
 * 123
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    //因为ServletConfig里定义了拦截所有请求交给SpringMvc处理，这里需要将静态资源排除在外
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pages/**").addResourceLocations("/static/pages/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
//        registry.addResourceHandler("/plugins/**").addResourceLocations("/static/plugins/");
        registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/static/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/static/plugins/");
    }

    @Override
    //定义拦截器拦截哪些请求，这里拦截/books和/books/*的请求
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books", "/books/*");
    }
}
