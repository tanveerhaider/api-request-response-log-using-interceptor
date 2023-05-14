package com.simplejava.logger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.simplejava.util.RequestResponseUtil;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 10:49 PM
 */
@Service
@Slf4j
@AllArgsConstructor
public class RequestResponseLoggingServiceImpl implements RequestResponseLoggingService {

    private final ObjectMapper objectMapper;

    private final RequestResponseUtil requestResponseUtil;

    @PostConstruct
    public void init(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    @Override
    public void logRequest(HttpServletRequest request, Object body) {
       log.info("REQUEST::");
        try {
            log.info("Method::[" +request.getMethod()+"]");
            log.info("Path::" + request.getRequestURI());
            Map<String, List<String>> headerMap = requestResponseUtil.extractHeadersFromRequest(request);
            Map<String, String[]> paramterMap = requestResponseUtil.extractParamtersFromRequest(request);
            log.info("Headers::" + objectMapper.writeValueAsString(headerMap));
            log.info("Parameters::" + objectMapper.writeValueAsString(paramterMap));
            log.info("Request Body::" + objectMapper.writeValueAsString(body));
        }
        catch(Exception ex){
            log.warn("Unable to log request",ex);
        }


    }

    @Override
    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {
       log.info("RESPONSE::");
        try {
            Map<String, String> headerMap = requestResponseUtil.extractHeadersFromResponse(response);
            log.info("Header::" + objectMapper.writeValueAsString(headerMap));
            log.info("ResponseBody::" + objectMapper.writeValueAsString(body));
        }
        catch(Exception ex){
            log.warn("Unable to log request",ex);
        }
    }

}
