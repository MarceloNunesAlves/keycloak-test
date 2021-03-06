package com.example.oauth.keycloaktest;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
  		http
	        .antMatcher("/**")
	        .authorizeRequests()
	        .antMatchers("/api/**")
	        .authenticated();
  		http.logout()
           .logoutSuccessUrl("http://localhost:8080/auth/realms/dev/protocol/openid-connect/logout");
    }
    
    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }

}
