package cz.burios.ux.cancel.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		final String sqlUserName = "SELECT u.USER_NAME, u.USER_PASSWORD, u.ENABLED FROM user_credentials u WHERE u.USER_NAME = ?";
		final String sqlAuthorities = "SELECT u.USER_NAME, u.USER_ROLE FROM user_credentials u WHERE u.USER_NAME = ?";

		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery(sqlUserName)
			.authoritiesByUsernameQuery(sqlAuthorities)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin").access("hasRole('ADMIN')")
			.anyRequest().permitAll()
			.and()
			.formLogin()										// Allows users to authenticate with form based login,
			.loginPage("/login")								// specifies the location of the log in page,
			.loginProcessingUrl("/j_spring_security_check")		// login processing URL,
			.defaultSuccessUrl("/admin")						// default-target-url,
			.failureUrl("/login?error")							// authentication-failure-url,
			.usernameParameter("username")						// overrides Spring's default  j_username with username-parameter,
			.passwordParameter("password");						// overrides Spring's default j_password with password-parameter
		
		return http.build();
	}
}
