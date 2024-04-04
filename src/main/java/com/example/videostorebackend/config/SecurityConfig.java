package com.example.videostorebackend.config;

import com.example.videostorebackend.component.VideoStoreAuthenticationProvider;
import com.example.videostorebackend.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/users").authenticated()
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/shows/**", "/tv**", "/movies/**", "/movies**", "/", "/mostDemanded", "/login", "/register").permitAll()
                )
                .formLogin(Customizer.withDefaults())
//                .formLogin().disable()
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationProvider(){
        return new ProviderManager(Collections.singletonList(new VideoStoreAuthenticationProvider()));
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }
}
