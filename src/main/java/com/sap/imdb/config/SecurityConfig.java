package com.sap.imdb.config;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Resource
	private UserDao userDao;
	@Resource
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/create-products/**").hasRole("BRUXO") //seller security*/
				.antMatchers("/admconsole/registermovie").hasRole("ADMIN") /* CHANGE TO VENDOR AREA */
				.antMatchers("/admconsole/delete**").hasRole("ADMIN").antMatchers("/admconsole/edit*")
				.hasAnyRole("ADMIN", "MOD") /* CHANGE TO MODERATOR AREA */
				.antMatchers("/home**").permitAll().antMatchers("/user/wishlist/**").authenticated()
				.antMatchers("/rest/**") /* DELETE REST PAGE */
				.hasRole("ADMIN").and().formLogin().defaultSuccessUrl("/home").and().formLogin().loginPage("/login")
				.failureUrl("/login?error").usernameParameter("username").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and().csrf();
	}
}
