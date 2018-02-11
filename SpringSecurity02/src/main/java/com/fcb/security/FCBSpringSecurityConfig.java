package com.fcb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.fcb.security")
public class FCBSpringSecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private CustomSuccessHandler springSecurityConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/user").access("hasRole('USER')")
		.antMatchers("/admin").access("hasRole('ADMIN')")
		.and()
		.formLogin().loginPage("/fcblogin").successHandler(springSecurityConfig)
		//.defaultSuccessUrl("/user")
		.usernameParameter("user").passwordParameter("pass")
		.failureUrl("/fcblogin")
		.and()
		.logout().logoutSuccessUrl("/home")
		
		.and()
		.exceptionHandling().accessDeniedPage("/home").and().csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
                   .withUser("user").password("123").roles("USER")
                   .and()
                   .withUser("abc").password("1234").roles("USER")
                   .and()
                   .withUser("abcd").password("1234").roles("USER");
	}
	
}
