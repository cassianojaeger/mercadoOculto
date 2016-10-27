package com.sap.imdb.config;

import javax.activation.DataSource;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sap.imdb.dao.UserDao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private UserDao userDao;
	@Resource
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("cassiano").password("123456").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		
		auth.userDetailsService(userDetailsService);
		 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admconsole/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/home").permitAll()
				.antMatchers("/home/**").access("hasRole('ROLE_USER')")
				.and().formLogin().defaultSuccessUrl("/home");
	}
}