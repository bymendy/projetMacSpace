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



    /**
     * Filtre les requêtes HTTP pour authentifier les utilisateurs en fonction du token fourni.
     *
     * @param request la requête HTTP
     * @param response la réponse HTTP
     * @param filterChain la chaîne de filtres
     * @throws ServletException en cas de problème de filtrage
     * @throws IOException en cas de problème d'entrée/sortie
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String urlRequest= request.getRequestURI();

        // Si l'URL de la requête contient "/api/login", continuer le filtrage sans traitement supplémentaire

        //Login
        if (urlRequest.contains("/api/login")){
            filterChain.doFilter(request, response);
            return;
        }

        // Extraction du token
        try{
            String header = request.getHeader("Authorization");
            // Authentification
            //Authorization: bearer eyolfdilfsdkfdslkflsdkfjjdslfhlsdfjlsdfjlk
            String token = header.substring(7);
            UserDetails user = userService.findBytoken(token);

            if (user == null){
                filterChain.doFilter(request,response);
                return;

            }

            // On le passe aux controllers grace au context
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e) {
            logger.info("Trying parse token but failed");
        }
        filterChain.doFilter(request,response);
    }
}

