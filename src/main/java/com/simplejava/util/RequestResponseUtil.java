package com.simplejava.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 10:52 PM
 */
@Component
public class RequestResponseUtil {

    public Map<String, List<String>> extractHeadersFromRequest(HttpServletRequest request) {
        Map<String, List<String>> headersMap = Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        h -> Collections.list(request.getHeaders(h))
                ));

        return headersMap;
    }

    public Map<String,String[]> extractParamtersFromRequest(HttpServletRequest request){
        return request.getParameterMap();

    }


    public Map<String, String> extractHeadersFromResponse(HttpServletResponse response) {
        Map<String,String> headers = new HashMap<>();
        Collection<String> headerMap = response.getHeaderNames();
        for(String str : headerMap) {
            headers.put(str,response.getHeader(str));
        }
        return headers;
    }



    public HttpHeaders addCustomerHeader(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("app-tranaction-id",UUID.randomUUID().toString());
        return responseHeaders;
    }
}
