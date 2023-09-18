package com.example.myDemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select emp_id , password , state from employees where emp_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select emp_id , role from roles where emp_id=?");
        return jdbcUserDetailsManager;
    }

    /*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return  new JdbcUserDetailsManager(dataSource);
    }
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/members/addMember").hasRole("MANAGER")
                                .requestMatchers("employees/addEmployee").hasRole("MANAGER")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

    /*   @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("employee")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("employee","manager")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("employee","manager","admin")
                .build();

        return  new InMemoryUserDetailsManager(john,mary,susan);
    }
*/ //hardcoded user
}
