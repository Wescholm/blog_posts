package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CacheControlRemover implements Filter {

    Logger LOGGER = LoggerFactory.getLogger(CacheControlRemover.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Cache-Control", "no-cache, must-revalidate, max-age=0");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
