package com.stage.chu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
  UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
    UserDetails user = User.withUsername("aicha").password(passwordEncoder().encode("1234")).authorities("read").build();
    userDetailsService.createUser(user);
    return userDetailsService;
  }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http
      // Configurer la page de connexion personnalisée
      .formLogin()
          .loginPage("/loginForm")
          .permitAll() // Permet l'accès à la page de connexion sans authentification

      // Configurer les règles d'autorisation pour les autres requêtes
      .and()
      .authorizeHttpRequests()
          .requestMatchers("/loginForm").permitAll() // Permet l'accès à /loginForm sans authentification
          .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
          .and()
      .csrf().disable(); // Désactive CSRF pour simplifier les tests, mais en production, tu devrais utiliser une configuration plus sécurisée

  return http.build();
  }
}
