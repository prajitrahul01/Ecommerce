package com.example.Ecommerce.Config;

import com.example.Ecommerce.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Configuration // among the other beans this is the first priority
public class JwtFilter extends GenericFilterBean {
    private TokenService tokenService;

    // Constructor injection of TokenService for dependency injection
    public JwtFilter(TokenService tokenService){ this.tokenService = tokenService; }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)  req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        String token = httpServletRequest.getHeader("Authorization");
        // Handling pre-flight requests (OPTIONS)
        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())){
            // Pre-flight requests are allowed, so set the status to OK and proceed
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req, res);
        }
        // Allowing requests without token for specific paths
        if(AllowRequestWithoutToken(httpServletRequest)){
            // Requests to specific paths are allowed without a token, so set the status to OK and proceed
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req, res);
        }
        else{
            // Extract user ID from the token and set it as a request attribute
            Integer id = new Integer(tokenService.getUserIdToken(token));
            httpServletRequest.setAttribute("userId","id");
            // Proceed with the filter chain after setting the user ID attribute
            filterChain.doFilter(req, res);
        }
    }
    // Method to determine whether the request should be allowed without a token
    public boolean AllowRequestWithoutToken(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getRequestURI());
        // Allow requests without a token for paths containing "/user"
        if(httpServletRequest.getRequestURI().contains("/user"))
            return true;
        else
            return false;
    }
}
