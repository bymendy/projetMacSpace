package com.macsecurite.macsecurite.security;

import com.macsecurite.macsecurite.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/client/**").hasAnyAuthority("CLIENT") // patterns non definie
                .requestMatchers("/dashboard/**").hasAnyAuthority("ADMIN") // patterns non definie
                .anyRequest().permitAll()

        )

                .build();

    }
}
