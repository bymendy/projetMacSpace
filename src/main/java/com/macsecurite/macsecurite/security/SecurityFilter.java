package com.macsecurite.macsecurite.security;

import com.macsecurite.macsecurite.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String urlRequest= request.getRequestURI();


        //Login
        if (urlRequest.contains("/api/login")){
            filterChain.doFilter(request, response);
            return;;
        }

        try{
            String header = request.getHeader("Authorization");
            // Authentification
            //Authorization: bearer eyolfdilfsdkfdslkflsdkfjjdslfhlsdfjlsdfjlk
            String incomingJwt = header.substring(7);
            UserDetails user = UserService.getUserFromJwt(incomingJwt);

            // On le passe aux controllers grace au context
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e) {
            logger.info("Trying parse token but failed");
        }
        filterChain.doFilter(request,response);
    }
}

