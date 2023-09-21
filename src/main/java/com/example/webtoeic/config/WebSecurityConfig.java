package com.example.webtoeic.config;

import com.example.webtoeic.filter.JWTAuthenticationFilter;
import com.example.webtoeic.filter.JWTAuthorizationFilter;
import com.example.webtoeic.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Lazy
    private AuthenticationService authenticationService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/login/**",
                        "/auth/register/**",
                        "/swagger-ui/**",
                        "/v2/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/configuration/**",
                        "/swagger*/**",
                        "/webjars/springfox-swagger-ui/**").permitAll()
                .antMatchers("/**").authenticated()
//                .hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                //Filter cho việc đăng nhập
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), authenticationService))
                //Filter cho việc xác thực token
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), authenticationService));

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
