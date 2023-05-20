package net.palantir.palantirbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		/*http.authorizeHttpRequests((auth) ->
				auth.anyRequest().authenticated()
		).httpBasic(Customizer.withDefaults());*/

		http
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> {
					response.setHeader("WWW-Authenticate", "Basic realm=SignIn");
				})
				.and()
				.sessionManagement()
				.and()
				.authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
						.requestMatchers(HttpMethod.GET, "/auth/signin").authenticated())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/users").hasRole("ADMIN")
						.requestMatchers("/items").hasAnyRole("ADMIN", "USER")
						.anyRequest().authenticated())
				.httpBasic();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
