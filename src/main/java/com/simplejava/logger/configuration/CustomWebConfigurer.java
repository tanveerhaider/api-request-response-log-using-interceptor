package com.simplejava.logger.configuration;

import com.simplejava.logger.advice.InterceptLog;
import com.simplejava.logger.advice.InterceptLog;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 10:43 PM
 */
@Component
@AllArgsConstructor
public class CustomWebConfigurer implements WebMvcConfigurer {

    private final InterceptLog logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}
