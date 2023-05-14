package com.simplejava.filter;

import com.simplejava.util.RequestResponseUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 5/14/2023
 * Time: 12:34 AM
 */
@Component
public class ResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.addHeader("app-tranaction-id", UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
