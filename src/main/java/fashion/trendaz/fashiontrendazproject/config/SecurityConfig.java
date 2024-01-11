package fashion.trendaz.fashiontrendazproject.config;

import javax.sql.DataSource; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/v2/api-docs", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/fashion-trendaz-project-0.0.1-SNAPSHOT/hello").permitAll()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.POST, "/users/**").permitAll()
		.antMatchers(HttpMethod.GET, "/users").permitAll()
		.antMatchers(HttpMethod.POST, "/products/**").permitAll()
		.antMatchers(HttpMethod.GET, "/products").permitAll()
		.antMatchers(HttpMethod.POST, "/orders/**").permitAll()
		.antMatchers(HttpMethod.GET, "/orders").permitAll()
		.antMatchers(HttpMethod.POST, "/brand/**").permitAll()
		.antMatchers(HttpMethod.GET, "/brand").permitAll()
		.antMatchers(HttpMethod.POST, "/customers/**").permitAll()
		.antMatchers(HttpMethod.GET, "/customers").permitAll()
		.antMatchers(HttpMethod.GET, "/files/download/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
             .anyRequest().authenticated()
         .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
         .and()
         .logout()
             .permitAll();
	
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		    auth.jdbcAuthentication().dataSource(dataSource)
		        .usersByUsernameQuery("SELECT username, password, email FROM users WHERE username=?")
		        .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?")
		        .passwordEncoder(passwordEncoder());
		}

}
