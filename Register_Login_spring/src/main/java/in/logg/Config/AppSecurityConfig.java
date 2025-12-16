package in.logg.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import in.logg.service.CustomerService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig 
{
	@Autowired
	private CustomerService customerService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	  @Bean 
	  public AuthenticationManager
	  authenticationManager(AuthenticationConfiguration config) throws Exception {
	  return config.getAuthenticationManager(); 
	  }
	           
	  @Bean 
	  public AuthenticationProvider authenticationProvider() {
	  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	  authProvider.setUserDetailsService(customerService);
	  authProvider.setPasswordEncoder(passwordEncoder());
	  return authProvider;
	  }
	  
	// Source - https://stackoverflow.com/q
	// Posted by Hyusein Lesho
	// Retrieved 2025-12-16, License - CC BY-SA 4.0

	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	           .authorizeHttpRequests(authorize ->
	                                  authorize
	                                .requestMatchers("/register","/login")
	                                .permitAll()            
	                                 .anyRequest()
	                                 .authenticated() );
	                

	        return http.build();
	    }

	 

	 }




	  
	



