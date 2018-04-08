package com.xiao.Filter;

import javax.servlet.*;
import java.io.IOException;

public class shiroRightFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("委托给shiro的管理的Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("shiro过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("shiro 过滤器销毁");
    }
}
