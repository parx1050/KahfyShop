package com.kahfy.springboot.thymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
		
	}
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth 
			.inMemoryAuthentication() 
			.passwordEncoder(passwordEncoder())
			.withUser("admin").password("$2a$10$0/7oNbR/O6DnvZ61C16mYuT4MwX5Mpg44ryLBH621qJ1PFfRZsrsG")
			.roles("ADMIN");
	}



	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  
	  http 
	  	.csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/admin/**").hasAnyRole("ADMIN")
	  	.and() 
	  	.formLogin()
	  .defaultSuccessUrl("/api/members").permitAll()
	  .and()
      .logout().logoutUrl("http://localhost:8080/Shyu_Parker_Kahfy_SpringMVC/kahfy/home");
	  
	  }
	 
	
	
	
	
		/*
		 * @Override protected void configure(HttpSecurity http) throws Exception {
		 * 
		 * http .csrf().disable() .authorizeRequests().antMatchers("/login").permitAll()
		 * .anyRequest().authenticated() .and() .formLogin()
		 * .loginPage("/login").permitAll() .and()
		 * .logout().invalidateHttpSession(true).clearAuthentication(true).
		 * logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/logout-success").permitAll();
		 * 
		 * }
		 */
	 
	 
	 

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("parker").password(
	 * "1234").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
	
	

}
