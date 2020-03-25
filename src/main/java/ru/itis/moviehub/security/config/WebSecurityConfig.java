package ru.itis.moviehub.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/films/**").permitAll()
                .antMatchers("/top").permitAll()
                .antMatchers("/actors/**").permitAll()
                .antMatchers("/top").permitAll()
                .antMatchers("/scriptwriters/**").permitAll()
                .antMatchers("/producers/**").permitAll()
                .antMatchers("/afisha").permitAll()
                .antMatchers("/confirm/**").permitAll()
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/settings").authenticated()
                .antMatchers("/profile").authenticated()
                .antMatchers("/files").permitAll();

        http.formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .usernameParameter("login")
                .permitAll();

        http.rememberMe()
                .rememberMeCookieName("auth");

        http.logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/signIn")
                .permitAll();
    }
}
