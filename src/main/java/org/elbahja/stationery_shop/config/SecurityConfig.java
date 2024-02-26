package org.elbahja.stationery_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    UserDetailsService userDetailsService;

    public SecurityConfig(RestAuthenticationEntryPoint restAuthenticationEntryPoint, UserDetailsService userDetailsService) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .userDetailsService(userDetailsService)
                .httpBasic(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable())                           // For modifying requests via Postman
                .exceptionHandling(handing -> handing
                        .authenticationEntryPoint(restAuthenticationEntryPoint) // Handles auth error
                )
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login").permitAll()
                                .requestMatchers( HttpMethod.GET,"/catalogue/**").authenticated()
                                .anyRequest().permitAll()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // no session
                )
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/catalogue")
                    .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .build();
    }
}
