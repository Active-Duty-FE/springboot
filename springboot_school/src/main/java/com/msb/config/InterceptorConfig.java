package com.msb.config;

import com.msb.interceptor.LoginInterceptor;
import com.msb.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*InterceptorRegistration interceptorRegistration = registry.addInterceptor(testInterceptor);
        InterceptorRegistration interceptorRegistration1 = interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration1.excludePathPatterns("/login");*/

        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/login.html");
    }
}
