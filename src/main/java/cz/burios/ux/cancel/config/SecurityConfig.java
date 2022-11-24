package cz.burios.ux.cancel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cz.burios.ux.cancel.security.SampleAccessDeniedHandler;
import cz.burios.ux.cancel.security.UserAuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserAuthenticationService authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().and().formLogin().loginPage("/login")
				.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/index", true)
				.failureUrl("/accessDenied").successHandler(new SavedRequestAwareAuthenticationSuccessHandler()) // not
																													// necessary.
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/logoutPage");
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder authMgrBuilder) throws Exception {
		authMgrBuilder.authenticationProvider(authenticationProvider);
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new SampleAccessDeniedHandler();
	}
}