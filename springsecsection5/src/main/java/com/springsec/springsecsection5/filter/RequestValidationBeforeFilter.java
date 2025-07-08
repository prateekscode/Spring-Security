package com.springsec.springsecsection5.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RequestValidationBeforeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        String header = req.getHeader(HttpHeaders.AUTHORIZATION);
        if(null!=header){
            header=header.trim();
            if(StringUtils.startsWithIgnoreCase(header,"Basic")){
                header.substring(6).getBytes(StandardCharsets.UTF_8);
            }
        }
    }
}
