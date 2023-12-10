package com.emadd9.springboot.demoapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    //DB or LDAP
    //In memory
    //@Bean
    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    //@Bean
    /*public InMemoryUserDetailsManager createUserDetailManager(){

        UserDetails userDetails = User.builder()
                .username("emadd9")
                .password("1234")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);

    }*/


    @Bean
    public InMemoryUserDetailsManager createNewUserDetails(){

        String username1 = "emadd9";
        String username2 = "sudeb";
        String password = "1234";

        UserDetails userDetail1 = getUserDetails(username1, password);
        UserDetails userDetail2 = getUserDetails(username2, password);

        return new InMemoryUserDetailsManager(userDetail1,userDetail2);
    }

    private UserDetails getUserDetails(String username, String password) {
        Function<String, String> passwordEncoder
                = input ->passwordEncoder().encode(input);
        UserDetails userDetail = User.builder()
                 .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetail;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Authorize all http req
        http.authorizeHttpRequests(
                  auth -> auth.anyRequest().authenticated());
        //Show form login
        http.formLogin(withDefaults());
        //Disable CSRF
        http.csrf().disable();
        //frameoptions disabled
        http.headers().frameOptions().disable();
          return http.build();
    }
}
