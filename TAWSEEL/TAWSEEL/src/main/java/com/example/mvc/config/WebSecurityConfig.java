package com.example.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.mvc.services.CustomOAuth2UserService;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;
	@Autowired
	private CustomOAuth2UserService oauth2UserService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		
//		http.
//	        authorizeRequests()
//	            .antMatchers("/css/**", "/js/**", "/registration").permitAll()
//	            .anyRequest().authenticated()
//	            .and()
//	        .formLogin()
//	            .loginPage("/login")
////	            .defaultSuccessUrl("/", true)
//	            .permitAll()
//	            .and()
//	        .logout()
//	            .permitAll();
//		
//		return http.build();
//	}
	   @Bean
		protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			
			http.
		        authorizeRequests()
		            .antMatchers("/css/**", "/js/**", "/registration").permitAll()
		            .antMatchers("/admin/**").access("hasRole('ADMIN')")    // NEW
		            .anyRequest().authenticated()
		            .and()
		        .formLogin()
		            .loginPage("/login")
		            .permitAll()
		            .and()
		            .oauth2Login()
		            .loginPage("/registration")
		            .permitAll().and().logout().permitAll();
					
		            
			return http.build();
		}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 

}