package com.gestion.gestionecole.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired 
	CustomUserDetailsService userDetailsService;
	
	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	
	}
	// desactiver les sessions definir par spring et lui qu'on veut passer par les token avec jwt
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			
			http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/classes" ).permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/anneeScolaires" ).permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/eleves" ).permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/inscription" ).permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/dossiers" ).permitAll();
			http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
			http.authorizeRequests().antMatchers("/appUsers/**", "/appRoles/**").hasAuthority("ADMIN");
			
			http.authorizeRequests().anyRequest().authenticated();

			http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
			
			http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
			
//			http.csrf().disable()
//			// don't create session
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//				.authorizeRequests()
//				.antMatchers("/users/**","/login/**")
//				.permitAll()
//				.antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN")
//				.anyRequest().authenticated()
//			.and()
//				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
//				.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
			

		}
		

	
}
