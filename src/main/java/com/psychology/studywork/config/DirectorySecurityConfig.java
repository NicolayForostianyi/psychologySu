package com.psychology.studywork.config;

import com.psychology.studywork.model.Role;
import com.psychology.studywork.repository.PersonRepository;
import com.psychology.studywork.security.DirectoryUserDetailsService;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter {
    private PersonRepository personRepository;
    public DirectorySecurityConfig (PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(new DirectoryUserDetailsService(this.personRepository));
    }


}
