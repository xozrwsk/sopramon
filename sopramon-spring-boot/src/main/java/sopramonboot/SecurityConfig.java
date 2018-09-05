package sopramonboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests()
.antMatchers("/assets/**").permitAll()
.antMatchers("/**").hasAnyRole("ADMIN", "USER")
.and()
.formLogin()
.loginPage("/ma_page_de_login")
.loginProcessingUrl("/perform_login")
.defaultSuccessUrl("/home", true)
.failureUrl("/ma_page_de_login?error=true")
.permitAll()
.and()
.logout()
.logoutUrl("/ma_page_de_deconnexion")
.logoutSuccessUrl("/ma_page_de_login")
.permitAll();
}


@Bean
public PasswordEncoder passwordEncoder() {
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    System.out.println(bcrypt.encode("123456"));
return new BCryptPasswordEncoder();
}


}


