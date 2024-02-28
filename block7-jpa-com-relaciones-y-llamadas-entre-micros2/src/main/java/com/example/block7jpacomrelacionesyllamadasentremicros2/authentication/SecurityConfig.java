package com.example.block7jpacomrelacionesyllamadasentremicros2.authentication;

import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(authenticationConfiguration));
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf(config -> config.disable())
                .authorizeRequests(autor -> {
                    autor.requestMatchers("/login").permitAll();
                    autor.requestMatchers(GET, "/api/clientes/**").hasAnyAuthority("ROLE_USER");
                    autor.requestMatchers(POST, "/api/clientes/save/**").hasAnyAuthority("ROLE_ADMIN");
                    autor.requestMatchers(GET, "/api/productos/**").hasAnyAuthority("ROLE_USER");
                    autor.requestMatchers(POST, "/api/productos/save/**").hasAnyAuthority("ROLE_ADMIN");
                    autor.anyRequest().authenticated();
                });

        return http.build();
    }
}
