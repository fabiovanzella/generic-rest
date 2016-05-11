package br.com.exemplo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/entidade/**").hasRole("USER")
        .anyRequest().anonymous().and()
      .httpBasic().and()
      .csrf().disable();
  }
   
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
        .withUser("bob").password("bob123").authorities("ROLE_USER").and()
        .withUser("admin").password("admin123").authorities("ROLE_USER", "ROLE_ADMIN");
  }
}