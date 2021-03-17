package com.zln.personal.service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllowOriginFilter implements Filter {
    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");//* 表示该资源谁都可以用,从而实现跨域
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
        HttpServletRequest request = (HttpServletRequest) req;

        try {
            chain.doFilter(req, res);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    }
