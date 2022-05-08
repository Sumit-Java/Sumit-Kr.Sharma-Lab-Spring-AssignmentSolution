package com.springboot.students.recordmanagement.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.students.recordmanagement.Service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return (UserDetailsService) new UserDetailsServiceImpl();

	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/h2-console").permitAll()
		.antMatchers("/user", "/role").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/update", "/delete").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/savestudent", "/logout").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/list", "/addStudent").hasAnyAuthority("ADMIN", "USER")
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().formLogin()
		.and().logout()
		.and()
		.cors().and().csrf().disable()
		.headers().frameOptions().disable();
	}
	
	

}
