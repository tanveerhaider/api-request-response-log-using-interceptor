package com.simplejava.logger.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/9/2023
 * Time: 10:49 PM
 */
public interface RequestResponseLoggingService {

    void logRequest(HttpServletRequest request, Object body);

    void logResponse(HttpServletRequest request, HttpServletResponse response, Object body);
}
