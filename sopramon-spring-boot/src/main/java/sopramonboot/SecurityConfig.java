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
    System.out.println("1, mot de passe : " + bcrypt.encode("1"));
    System.out.println("2, mot de passe : " + bcrypt.encode("2"));
    System.out.println("3, mot de passe : " + bcrypt.encode("3"));
    System.out.println("4, mot de passe : " + bcrypt.encode("4"));
    System.out.println("5, mot de passe : " + bcrypt.encode("5"));
    System.out.println("6, mot de passe : " + bcrypt.encode("6"));
    System.out.println("7, mot de passe : " + bcrypt.encode("7"));
    System.out.println("8, mot de passe : " + bcrypt.encode("8"));
    System.out.println("9, mot de passe : " + bcrypt.encode("9"));
    System.out.println("10, mot de passe : " + bcrypt.encode("10"));
return new BCryptPasswordEncoder();
}


}


