package com.macsecurite.macsecurite.security;

import com.macsecurite.macsecurite.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilter securityFilter(){
        return new SecurityFilter();
    }

    /**
     * Crée un bean BCryptPasswordEncoder pour gérer le chiffrement des mots de passe.
     *
     * @return une instance de BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Crée un bean UserService pour gérer les opérations liées aux utilisateurs.
     *
     * @return une instance de UserService
     */
    @Bean
    public UserService userService() {
        return new UserService();
    }

    /**
     * Configure le bean DaoAuthenticationProvider pour utiliser le UserService pour charger les données utilisateur
     * et le BCryptPasswordEncoder pour encoder les mots de passe.
     *
     * @return une instance configurée de DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService());
        return daoAuthenticationProvider;
    }

    /**
     * Configure la chaîne de filtres de sécurité pour l'application HTTP.
     *
     * @param http l'objet HttpSecurity à modifier
     * @return une instance de SecurityFilterChain
     * @throws Exception si une erreur survient lors de la configuration de HttpSecurity
     */
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/api/login").permitAll()
                        .requestMatchers("/api/client/**").hasAnyAuthority("CLIENT") // Définir le contrôle d'accès pour les points de terminaison client
                        .requestMatchers("/api/dashboard/**").hasAnyAuthority("ADMIN") // Définir le contrôle d'accès pour les points de terminaison admin
                        .anyRequest().permitAll() // Autoriser toutes les autres requêtes
                )

                .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}