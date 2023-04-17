package com.vacaciones.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.vacaciones.services.detailsService.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    MyAuthenticationEntryPoint authenticationEntryPoint;

    JpaUserDetailsService service;

    public SecurityConfiguration(JpaUserDetailsService service) {
        this.service = service;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .cors()
            .and()
            .headers(header -> header.frameOptions().sameOrigin())
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form
                       .disable())
            .logout(out -> out 
                    .logoutUrl("/api/logout")
                    .deleteCookies("JSESSIONID"))
            .authorizeHttpRequests(auth -> auth 
                                   .requestMatchers("/api/register").permitAll()
                                   .requestMatchers("/api/login").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_RESPONSABLE")
                                   .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
                                   .requestMatchers("api/user/**").hasAnyAuthority("ROLE_USER", "ROLE_RESPONSABLE")
                                   .requestMatchers("api/responsable/**").hasAnyAuthority("ROLE_RESPONSABLE", "ROLE_ADMIN")
                                   .anyRequest()
                                   .authenticated())
            .userDetailsService(service)
            .sessionManagement(session -> session
                               .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
            .httpBasic(basic -> basic
                       .authenticationEntryPoint(authenticationEntryPoint));
            
            return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    
}
