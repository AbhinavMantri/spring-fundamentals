package com.mycode.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class DemoSecurityConfig {
    // # inmemory 
    // @Bean
    // public InMemoryUserDetailsManager userDetailManager() {
    //     UserDetails john = User.builder()
    //                 .username("john")
    //                 .password("{noop}john123")
    //                 .roles("EMPLOYEE")
    //                 .build();
        
    //     UserDetails riya = User.builder()
    //                 .username("riya")
    //                 .password("{noop}riya123")
    //                 .roles("EMPLOYEE", "MANAGER")
    //                 .build();

    //     UserDetails susan = User.builder()
    //                 .username("susan")
    //                 .password("{noop}susan123")
    //                 .roles("EMPLOYEE", "MANAGER", "ADMIN")
    //                 .build();            


    //    return new InMemoryUserDetailsManager(john, riya, susan);             
    // }

    // # jdbc db tables
    @Bean
    public UserDetailsManager userDetailManager(DataSource source) {
        JdbcUserDetailsManager jManager = new JdbcUserDetailsManager(source);

        jManager.setUsersByUsernameQuery("select userName, password, enabled from users where userName=?");

        jManager.setAuthoritiesByUsernameQuery("select userName, authority from authorities where userName=?");

        return jManager;
    }

    @Bean
    public AmazonS3 s3Client() {
       return AmazonS3ClientBuilder.standard().build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http.csrf().disable();

        http
        .authorizeHttpRequests(configurer -> 
            configurer
                // .requestMatchers(HttpMethod.GET, "/api/students").hasRole("EMPLOYEE")
                // .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("EMPLOYEE")
                // .requestMatchers(HttpMethod.POST, "/api/students").hasRole("MANAGER")
                // .requestMatchers(HttpMethod.PUT, "/api/students/**").hasRole("MANAGER")
                // .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
                // .requestMatchers("/api/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .anyRequest().permitAll()
        );

        // use http authentication
        http.httpBasic();

        http.csrf().disable();

        return http.build();
    }
}
