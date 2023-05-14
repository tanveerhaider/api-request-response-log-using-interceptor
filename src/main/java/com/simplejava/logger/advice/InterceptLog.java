package com.simplejava.logger.advice;

import com.simplejava.logger.service.RequestResponseLoggingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Description : This is being used to intecept and Log request corresponding to GET/DELETE call
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 11:00 PM
 */
@Component
@AllArgsConstructor
public class InterceptLog implements HandlerInterceptor {

    private final RequestResponseLoggingService loggingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals(HttpMethod.GET.name())
                || request.getMethod().equals(HttpMethod.DELETE.name())){
            loggingService.logRequest(request,null);
        }
        return true;
    }
}
