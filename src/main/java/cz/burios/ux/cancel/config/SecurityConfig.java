package cz.burios.ux.cancel.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT USER_NAME, USER_PASSWORD, ENABLED " + "FROM user_credentials " + "WHERE USER_NAME = ?")
			.authoritiesByUsernameQuery("SELECT USER_NAME, USER_ROLE " + "FROM user_credentials " + "WHERE USER_NAME = ?")
			;
			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login", "/logout")
			.permitAll()
			.antMatchers("/p/desktop")
			.authenticated()
			.and()
				.formLogin().loginPage("/login")
			.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
