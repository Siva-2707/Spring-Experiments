package com.siva.springsecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                //Order of roles matters.
                http
                                .authorizeHttpRequests(req -> 
                                {
                                        req.antMatchers("/admin")
                                                .hasRole("ADMIN");
                                        req.antMatchers("/", "/home")
                                                .permitAll()
                                                .anyRequest()
                                                .authenticated();
                                        
                                })
                                .logout(logout -> logout.permitAll())
                                .formLogin();

                
                return http.build();
        }

        @Bean 
        public UserDetailsManager users(DataSource dataSource){
                return new JdbcUserDetailsManager(dataSource);
        }

        @Bean
        public PasswordEncoder getPasswordEncoder(){
                //return NoOpPasswordEncoder.getInstance(); // Not used after Spring Security 5.0
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

}
