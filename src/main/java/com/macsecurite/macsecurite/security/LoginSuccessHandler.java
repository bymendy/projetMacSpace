package com.macsecurite.macsecurite.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.macsecurite.macsecurite.model.Users;

import com.macsecurite.macsecurite.model.Role;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Users user = (Users) authentication.getPrincipal();

        String redirectURL ;

        for (Role role : user.getRoles()){
            switch (role.getName()){
                case "ADMIN":
                    redirectURL = "/dashboard";
                    break;
                case "CLIENT" :
                    redirectURL = "/client";
                    break;
                default:
                    redirectURL = "/login";
                    break;
            }
            response.sendRedirect(redirectURL);
            return;
        }
    }

}
