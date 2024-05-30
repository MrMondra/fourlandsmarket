package com.fourlands.common.infrastructure;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@Order(1)
public class TenantFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(TenantFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;
        String tenantName = req.getHeader("X-Tenant-ID");

        if (tenantName != null) {
            TenantContext.setCurrentTenant(tenantName);
        }
        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }

    }
}