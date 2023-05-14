package com.simplejava.logger.advice;

import com.simplejava.logger.service.RequestResponseLoggingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 10:45 PM
 */
@ControllerAdvice
@AllArgsConstructor
public class RequestBodyInterceptor extends RequestBodyAdviceAdapter {
    private final RequestResponseLoggingService logService;

    private final HttpServletRequest request;


    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        logService.logRequest(request,body);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
}
