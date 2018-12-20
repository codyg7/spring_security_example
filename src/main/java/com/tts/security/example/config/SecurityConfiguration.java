package com.tts.security.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tts.security.example.services.AppUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	//This basically says that a GET request to / or css/ and all sub directories will work without being authenticated. 
	//Everything other route would require a login
	//
	// you could add the following in between the first anyMathers and .anyRequest to lock down urls based on role
	//
	//.antMatchers("/admin/**").hasRole("ADMIN")
	//.antMatchers("/invoices/**").hasAnyRole("ADMIN", "ACCOUNTANT")
	//.antMatchers("/billing-records/**").hasAnyRole("CLERK", "ADMIN")
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/css/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}
	
}
