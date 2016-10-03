package com.vchauhan.security;

import com.vchauhan.service.BoxService;
import com.vchauhan.web.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vineet on 9/15/16.
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
    private TokenAuthService tokenAuthenticationService;

    public LoginFilter(String urlMapping, AuthenticationManager authenticationManager, TokenAuthService tokenAuthenticationService) {
        super(new AntPathRequestMatcher(urlMapping));
        setAuthenticationManager(authenticationManager);
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        log.info("Authenticating user {} "+ request.getParameter("username"));

        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.getParameter("username"), request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException, ServletException {

        tokenAuthenticationService.addAuthentication(response, (TokenUser) authentication.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}