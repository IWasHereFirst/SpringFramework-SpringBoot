package com.daniellesko.springboot101.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectConfig {

    /**
     * UserDetails - kontrakt, v ktorom sa definuje uzivatel
     * UserDetailsService - kontrakt, ktory sluzi na ziskavanie uzivatelov
     * - obsahuje len jednu metodu loadUserByUsername, ktora sluzi na nacitanie uzivatelov z rozlicnych zdrojov (in memory, subor, DB, webservice, socket: LDAP AC)
     * UserDetailsManager - sluzi na spravu uzivatelov (pridanie, odstranenie, uprava atd...)
     * PasswordEncoder - sluzi na zakryptovanie hesla
     */

    // Toto sa pouziva inak, tu je to len aby to fungovalo, pretoze hesla musia byt zaheslovane
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  // InMemoryUserDetailsManager implementuje UserDetailsManager

        UserDetails u1 = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .authorities("read")
                .build();

        UserDetails u2 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .roles("MANAGER")
                .authorities("read")
                .build();

        manager.createUser(u1);
        manager.createUser(u2);

        return manager;
    }*/

    // Sluzi rovnako ko kod vyssie
    @Bean
    public InMemoryUserDetailsManager detailsManager(){
        UserDetails u1 = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .authorities("read")
                .build();
        UserDetails u2 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(u1, u2);
    }

    // WebSecurityConfigurerAdapter z lekcie nefunguje, toto je modernejsia varianta
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello").authenticated()
                        .anyRequest().denyAll()
                ).httpBasic();
        return http.build();
    }
}
