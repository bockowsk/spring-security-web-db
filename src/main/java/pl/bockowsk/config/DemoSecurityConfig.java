package pl.bockowsk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
/*		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("1234abcd").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(users.username("tomek").password("1234abcd").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(users.username("olimp").password("1234abcd").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("astutus").password("1234abcd").roles("EMPLOYEE","ADMIN"));
*/	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE","ADMIN","MANAGER").antMatchers("/managers/**").hasRole("MANAGER")
				.antMatchers("/admins/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticate").permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
